package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    void addEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    List<EventDTO> getEventsByDate(LocalDateTime date);

    List<EventDTO> getEventsOfType(String accessType);

    void updateEvent(EventDTO eventDTO);

   void addUserToWaitingList(UserDTO userDTO, EventDTO eventDTO);

   void acceptUser(UserDTO userDTO, EventDTO eventDTO);

    EventDTO findEventByUuid(String uuid);


}
