package pete.eremeykin.http.service.song;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pete.eremeykin.service.api.Song;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SongService {
    private final SongMapper mapper;
    private final SongRepository repository;

    public List<Song> findAllByUserId(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toDto).toList();
    }
}
