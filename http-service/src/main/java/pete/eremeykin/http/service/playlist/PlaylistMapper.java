package pete.eremeykin.http.service.playlist;

import org.springframework.stereotype.Component;
import pete.eremeykin.service.api.Playlist;
import pete.eremeykin.service.api.Song;
import pete.eremeykin.service.api.User;

import java.util.List;

@Component
class PlaylistMapper {

    public Playlist fromUserAndSongs(User user, List<Song> userSongs) {
        return new Playlist(user, userSongs);
    }
}
