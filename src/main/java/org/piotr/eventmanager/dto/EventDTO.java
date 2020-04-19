package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.utils.EventAccessType;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class EventDTO {

    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private User eventOwner;
    private List<User> participants;


}
