package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.Comment;
import org.piotr.eventmanager.entity.eventModels.Address;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@NoArgsConstructor
public class EventDTO {

    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private Address eventAddress;
    private UserDTO eventOwner;
    private Set<UserDTO> acceptedUsers;
    private Set<User> waitingList;
    private String uuid;
    private Set<Comment> comments;


}
