package ru.tuzov.restchooser.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.tuzov.restchooser.model.User;
import ru.tuzov.restchooser.to.UserTo;

import static ru.tuzov.restchooser.model.Role.USER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getEmail(), userTo.getFirstName(), userTo.getLastName(), userTo.getPassword(), USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
    }
}
