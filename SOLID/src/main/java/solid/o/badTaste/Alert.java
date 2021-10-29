package solid.o.badTaste;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Alert {
    private final AlertRule alertRule;
    private final Notification notification;

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }


// If we want to add a new parameter called timeoutCount in check,
// we would need to change the function signature, as well as
// the logic in the method.

// Change 1: Add a new parameter
    public void check(String api, long requestCount, long errorCount, long timeoutCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }

        // Change 2: Add logic for timeout process
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > alertRule.getMatchedRule(api).getMaxTimeoutTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}