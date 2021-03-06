package ru.tuzov.restchooser;

import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import ru.tuzov.restchooser.model.User;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    @NonNull
    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int getId() {
        return user.id();
    }
}
