package pete.eremeykin.service.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericResponse<T> {
    private final T data;

    public static <T> GenericResponse<T> ofData(T data) {
        return new GenericResponse<>(data);
    }
}
