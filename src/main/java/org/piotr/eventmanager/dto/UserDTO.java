package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String email;

    private String uuid;

}
