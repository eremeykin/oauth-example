package pete.eremeykin.http.service.song;

import org.springframework.stereotype.Component;
import pete.eremeykin.service.api.Song;

@Component
class SongMapper {

    Song toDto(SongEntity entity) {
        return new Song(
                entity.getId(),
                entity.getName(),
                entity.getArtist()
        );
    }

}
