package ru.tuzov.restchooser.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.tuzov.restchooser.HasId;
import ru.tuzov.restchooser.util.exception.IllegalRequestDataException;
import ru.tuzov.restchooser.util.exception.NotFoundException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean + " must be new (id=null)");
        }
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }
}
