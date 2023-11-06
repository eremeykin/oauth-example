package pete.eremeykin.http.service.song;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

interface SongRepository extends CrudRepository<SongEntity, UUID> {

    @Query(value = """
            select * from songs song
                join user_songs user_song on user_song.song_id = song.id
            where user_song.user_id = :userId
            order by song.id desc
            """, nativeQuery = true)
    List<SongEntity> findAllByUserId(UUID userId);
}
