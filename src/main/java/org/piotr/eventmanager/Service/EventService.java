package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    void addEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    List<EventDTO> getEventsByDate(LocalDateTime date);

    List<EventDTO> getEventsOfTypePublic();

}
