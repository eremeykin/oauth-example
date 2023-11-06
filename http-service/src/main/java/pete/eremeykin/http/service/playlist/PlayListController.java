package pete.eremeykin.http.service.playlist;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pete.eremeykin.service.api.GenericResponse;
import pete.eremeykin.service.api.Playlist;

import static pete.eremeykin.service.api.client.ApiClient.PLAYLIST_ENDPOINT;

@AllArgsConstructor
@RestController
@RequestMapping(PLAYLIST_ENDPOINT)
class PlayListController {
    private final PlaylistService service;

    @GetMapping
    GenericResponse<Playlist> getPlaylist() {
        Playlist userPlaylist = service.getCurrentUserPlaylist();
        return GenericResponse.ofData(userPlaylist);
    }
}
