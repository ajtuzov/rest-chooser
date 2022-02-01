package ru.tuzov.restchooser;

import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import ru.tuzov.restchooser.model.User;
import ru.tuzov.restchooser.to.UserTo;
import ru.tuzov.restchooser.util.UserUtil;

@Getter
@ToString(of = "userTo")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    @NonNull
    private final UserTo userTo;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public int getId() {
        return userTo.id();
    }
}
