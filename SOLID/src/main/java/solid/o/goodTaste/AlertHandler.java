package solid.o.goodTaste;

import solid.o.badTaste.Notification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AlertHandler {
    private AlertRule alertRule;
    private Notification notification;

    public abstract void check(ApiStatInfo apiStatInfo);

}
