package pete.eremeykin.http.service.playlist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pete.eremeykin.http.service.song.SongService;
import pete.eremeykin.http.service.song.user.UserService;
import pete.eremeykin.service.api.Playlist;
import pete.eremeykin.service.api.Song;
import pete.eremeykin.service.api.User;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
class PlaylistService {
    private final SongService songService;
    private final UserService userService;
    private final PlaylistMapper playlistMapper;

    Playlist getCurrentUserPlaylist() {
        User user = userService.getCurrentUser();
        List<Song> userSongs = songService.findAllByUserId(user.getId());
        return playlistMapper.fromUserAndSongs(user, userSongs);
    }
}
