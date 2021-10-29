package authenticationProject.token;

import lombok.Value;

@Value
public class AuthToken {

    long DEFAULT_EXPIRATION_DURATION = 60 * 60; // 1h expiration
    String token;
    long createTime;

    public static AuthToken create(String baseUrl, String appId, String password, long timestamp) {
        long createTime = timestamp;
        String token = baseUrl + appId + password;
        return new AuthToken(token, createTime);
    }


    public boolean isExpired() {
        long currentTime = System.currentTimeMillis() / 1000;
        return createTime + DEFAULT_EXPIRATION_DURATION < currentTime;
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }
}
