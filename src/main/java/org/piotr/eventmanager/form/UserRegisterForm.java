package org.piotr.eventmanager.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.piotr.eventmanager.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;


@Data
@ToString
@EqualsAndHashCode
public class UserRegisterForm {

    private final String uuid = UUID.randomUUID().toString();
    @NotNull
    @Size(min=3, message = "Login musi składać się z przynajmniej trzech znaków.")
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String matchingPassword;
    @NotNull
    private String userName;
    @Email
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(uuid, login, passwordEncoder.encode(password), userName, email);
    }



}
