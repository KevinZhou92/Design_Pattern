package solid.o.goodTaste;

import solid.o.badTaste.Notification;

public class MaxErrorAlertHandler extends AlertHandler {
    public MaxErrorAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
}
