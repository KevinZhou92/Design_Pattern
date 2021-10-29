package solid.o.goodTaste;

public interface AlertRule {
    Object getMatchedRule(String api);

    void check(ApiStatInfo apiStatInfo);
}
