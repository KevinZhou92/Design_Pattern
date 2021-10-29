package solid.o.badTaste;

public interface Rule {
    long getMaxTps();

    long getMaxErrorCount();

    long getMaxTimeoutTps();
}
