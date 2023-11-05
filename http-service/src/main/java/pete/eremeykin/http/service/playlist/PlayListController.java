package pete.eremeykin.http.service.playlist;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pete.eremeykin.service.api.GenericResponse;
import pete.eremeykin.service.api.Playlist;

@AllArgsConstructor
@RestController
@RequestMapping("playlist")
class PlayListController {
    private final PlaylistService service;

    @GetMapping
    GenericResponse<Playlist> getPlaylist() {
        Playlist userPlaylist = service.getCurrentUserPlaylist();
        return GenericResponse.ofData(userPlaylist);
    }
}
