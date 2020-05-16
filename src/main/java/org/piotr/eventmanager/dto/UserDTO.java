package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.userModels.Authority;
import org.piotr.eventmanager.info.EventInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private String uuid;
    private String login;
    private String userName;
    private String email;
    private Set<String> userWaitingList;
    private Set<String> events;
    private Set<String> ownedEvents;
    private Set<String> comments;


}
