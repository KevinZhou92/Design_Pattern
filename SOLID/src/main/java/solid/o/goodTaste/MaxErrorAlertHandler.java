package solid.o.goodTaste;

import solid.o.badTaste.Notification;
import solid.o.badTaste.NotificationEmergencyLevel;

public class MaxErrorAlertHandler extends AlertHandler {
    public MaxErrorAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
}
