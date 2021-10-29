package solid.o.goodTaste;

import lombok.Getter;

@Getter
public class ApiStatInfo {
    String api;
    long requestCount;
    long errorCount;
    long timeoutCount;
    long durationOfSeconds;
}
