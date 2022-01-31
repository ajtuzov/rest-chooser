package ru.tuzov.restchooser.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
public class UserTo extends BaseTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Email
    @NotBlank
    @Size(max = 128)
    private String email;

    @NotBlank
    @Size(min = 2, max = 128)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 128)
    private String lastName;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;
}
