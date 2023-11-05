package pete.eremeykin.service.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Song {
    private final UUID id;
    private final String name;
    private final String artist;
}
