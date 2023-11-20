package pete.eremeykin.client.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import static java.util.Objects.isNull;

@Slf4j
@AllArgsConstructor
public class OAuthClientCredentialsFeignManager {
    private final OAuth2AuthorizedClientManager authorizedClientManager;
    private final ClientRegistration clientRegistration;


    public String getAccessToken() {
        OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(clientRegistration.getRegistrationId())
                .principal(SecurityContextHolder.getContext().getAuthentication())
                .build();
        OAuth2AuthorizedClient client = authorizedClientManager.authorize(oAuth2AuthorizeRequest);
        if (isNull(client)) {
            throw new IllegalStateException("client credentials flow on " + clientRegistration.getRegistrationId() + " failed, client is null");
        }
        return client.getAccessToken().getTokenValue();
    }
}
