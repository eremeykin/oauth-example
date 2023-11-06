package pete.eremeykin.client.app.recommendation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pete.eremeykin.service.api.GenericResponse;
import pete.eremeykin.service.api.Playlist;
import pete.eremeykin.service.api.client.ApiClient;

import java.util.Collections;

@RestController
@AllArgsConstructor
@RequestMapping("recommendation")
public class RecommendationController {
    private final ApiClient apiClient;

    @GetMapping
    GenericResponse<Recommendation> getRecommendations() {
        Playlist userPlaylist = apiClient.getPlaylist().getData();
        Recommendation recommendation = new Recommendation(userPlaylist, Collections.emptyList());
        return GenericResponse.ofData(recommendation);
    }
}
