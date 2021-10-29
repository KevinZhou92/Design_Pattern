package solid.o.goodTaste;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Alert {
    private final List<AlertHandler> alertHandlers;

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler: alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }
}
