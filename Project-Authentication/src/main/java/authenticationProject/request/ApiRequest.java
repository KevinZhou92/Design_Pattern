package authenticationProject.request;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ApiRequest {
    String appId;
    String baseUrl;
    String token;
    long timestamp;

    public static ApiRequest buildFromUrl(String url) {
        String token = url;
        String appId = url;
        String baseUrl = url;
        long timestamp = Long.parseLong(url);

        return new ApiRequest(appId, baseUrl, token, timestamp);
    }
}
