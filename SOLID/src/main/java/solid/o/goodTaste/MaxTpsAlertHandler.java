package solid.o.goodTaste;

import solid.o.badTaste.Notification;
import solid.o.badTaste.NotificationEmergencyLevel;

public class MaxTpsAlertHandler extends AlertHandler {
    public MaxTpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
