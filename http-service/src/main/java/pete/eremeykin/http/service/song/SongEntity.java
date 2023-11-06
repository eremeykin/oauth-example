package pete.eremeykin.http.service.song;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = SongEntity.PLAYLISTS)
class SongEntity {
    protected static final String PLAYLISTS = "songs";

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String artist;
}
