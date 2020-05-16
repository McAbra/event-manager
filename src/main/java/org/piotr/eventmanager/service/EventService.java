package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface EventService {

    String addEvent(EventDTO eventDTO);

    Set<EventDTO> getAllEvents();

    Set<EventDTO> getEventsByDate(LocalDateTime date);

    Set<EventDTO> getEventsOfType(String accessType);

    void updateEvent(EventDTO eventDTO);

    void addUserToWaitingList(String eventUuid);

    void acceptUser(UserDTO userDTO, EventDTO eventDTO);

    EventDTO findEventByUuid(String uuid);


}
