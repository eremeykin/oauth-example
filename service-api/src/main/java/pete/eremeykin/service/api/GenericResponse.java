package pete.eremeykin.service.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericResponse<T> {
    private final T data;

    public static <T> GenericResponse<T> ofData(T data) {
        return new GenericResponse<>(data);
    }
}
