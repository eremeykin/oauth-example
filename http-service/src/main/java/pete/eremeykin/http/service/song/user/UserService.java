package pete.eremeykin.http.service.song.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pete.eremeykin.service.api.User;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    protected static final String EMAIL_CLAIM = "email";

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal() instanceof Jwt jwt)) {
            throw new UserNotFoundException();
        }
        UUID userId = UUID.fromString(jwt.getSubject());
        String email = jwt.getClaimAsString(EMAIL_CLAIM);
        return new User(userId, email);
    }
}
