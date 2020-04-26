package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    void addEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    List<EventDTO> getEventsByDate(LocalDateTime date);

    List<EventDTO> getEventsOfType(String accessType);

}
