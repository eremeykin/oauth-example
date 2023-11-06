package pete.eremeykin.client.app.recommendation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pete.eremeykin.service.api.Playlist;
import pete.eremeykin.service.api.Song;

import java.util.List;

@Getter
@AllArgsConstructor
class Recommendation {
    private final Playlist playlist;
    private final List<Song> recommendedSongs;
}
