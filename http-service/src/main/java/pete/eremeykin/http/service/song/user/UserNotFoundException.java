package pete.eremeykin.http.service.song.user;

import java.util.UUID;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    UserNotFoundException(UUID userId) {
        super("User with id %s not found".formatted(userId));
    }
}
