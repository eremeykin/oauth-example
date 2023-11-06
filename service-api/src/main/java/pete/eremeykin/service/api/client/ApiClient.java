package pete.eremeykin.service.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pete.eremeykin.service.api.GenericResponse;
import pete.eremeykin.service.api.Playlist;

@FeignClient(
        name = "ApiClient",
        url = "${api.client.url}"
)
public interface ApiClient {
    String PLAYLIST_ENDPOINT = "playlist";

    @GetMapping(PLAYLIST_ENDPOINT)
    GenericResponse<Playlist> getPlaylist();
}
