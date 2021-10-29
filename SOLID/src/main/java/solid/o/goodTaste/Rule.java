package solid.o.goodTaste;

public interface Rule {
    long getMaxTps();

    long getMaxErrorCount();

    long getMaxTimeoutTps();
}
