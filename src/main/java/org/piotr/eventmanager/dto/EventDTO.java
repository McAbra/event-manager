package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.eventUtils.Address;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.eventUtils.EventAccessType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private Address eventAddress;
    private User eventOwner;
    private Set<User> acceptedParticipants;
    private Set<User> waitingList;


}
