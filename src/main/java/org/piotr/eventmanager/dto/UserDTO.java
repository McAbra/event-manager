package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    private String login;
    private String password;
    private String userName;
    private String email;

}
