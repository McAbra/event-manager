package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private String userName;
    private String email;

}
