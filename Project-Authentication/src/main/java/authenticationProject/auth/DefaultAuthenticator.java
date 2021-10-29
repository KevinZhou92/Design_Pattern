package authenticationProject.auth;

import authenticationProject.request.ApiRequest;
import authenticationProject.storage.CredentialStorage;
import authenticationProject.storage.MysqlCredentialStorage;
import authenticationProject.token.AuthToken;

public class DefaultAuthenticator implements Authenticator {
    
    private final CredentialStorage credentialStorage;
    
    public DefaultAuthenticator() {
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultAuthenticator(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }
    
    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);

    }

    private void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String baseUrl = apiRequest.getBaseUrl();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();

        AuthToken customerToken = new AuthToken(token, timestamp);
        if (customerToken.isExpired()) {
            throw new RuntimeException("Token is expired!");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverToken = AuthToken.create(baseUrl, appId, password, timestamp);
        if (!serverToken.match(customerToken)) {
            throw new RuntimeException("Invalid Token!");
        }
    }
}
