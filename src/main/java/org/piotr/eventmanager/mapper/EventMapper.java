package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.utils.EventAccessType;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static EventDTO mapEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(event.getEventOwner());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setName(event.getName());
        eventDTO.setParticipants(null); //fixme
        return eventDTO;
    }

    public static List<EventDTO> mapEventListToDtoList(Iterable<Event> events) {
        List<EventDTO> dtos = new ArrayList<>();
        for (Object e : events) {
            dtos.add(mapEventToDto((Event)e));
        }
        return dtos;
    }

    public static Event mapEventDtoToEvent(EventDTO eventDTO){
        Event event = new Event();
        event.setAccessType(eventDTO.getAccessType());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventOwner(eventDTO.getEventOwner());
        event.setName(eventDTO.getName());
        event.setEventAddress(eventDTO.getEventAddress());
        event.setEventAddress(eventDTO.getEventAddress());

        return event;
    }
}
