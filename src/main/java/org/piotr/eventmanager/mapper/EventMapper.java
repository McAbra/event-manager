package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static EventDTO mapEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(event.getEventOwner());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setName(event.getName());
        eventDTO.setParticipants(null); //fixme
        return eventDTO;
    }

    public static List<EventDTO> mapEventListToDtoList(Iterable<Event> events) {
        List<EventDTO> dtos = new ArrayList<>();
        for (Event e : events) {
            dtos.add(mapEventToDto(e));
        }
        return dtos;
    }

    public static Event mapEventDtoToEvent(EventDTO eventDTO){
        Event event = new Event();
        event.setAccessType(eventDTO.getAccessType());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventOwner(eventDTO.getEventOwner());
        event.setName(eventDTO.getName());
        return event;
    }
}
