package solid.o.goodTaste;

import solid.o.badTaste.Notification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AlertHandler {
    protected AlertRule alertRule;
    protected Notification notification;

    public abstract void check(ApiStatInfo apiStatInfo);

}
