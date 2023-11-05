package pete.eremeykin.service.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Playlist {
    private final User user;
    private final List<Song> songs;
}
