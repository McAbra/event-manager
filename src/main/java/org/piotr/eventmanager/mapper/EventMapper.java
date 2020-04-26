package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.form.NewEventForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventMapper {

    public static EventDTO mapEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(event.getEventOwner());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setName(event.getName());
        eventDTO.setAcceptedParticipants(null);//fixme
        eventDTO.setWaitingList(null);//fixme
        return eventDTO;
    }

    public static List<EventDTO> mapEventListToDtoList(Iterable<Event> events) {
        List<EventDTO> dtos = new ArrayList<>();
        for (Object e : events) {
            dtos.add(mapEventToDto((Event) e));
        }
        return dtos;
    }

    public static Event mapEventDtoToEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setAccessType(eventDTO.getAccessType());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventOwner(eventDTO.getEventOwner());
        event.setName(eventDTO.getName());
        event.setEventAddress(eventDTO.getEventAddress());
        event.setWaitingList(eventDTO.getWaitingList());
        //TODO - add acceptedParticipants
        return event;
    }

    public static Event mapEventFormToEvent(NewEventForm newEventForm) {
        Event event = new Event();
        event.setName(newEventForm.getName());
        event.setAccessType(newEventForm.getAccessType());
        event.setEventAddress(newEventForm.getEventAddress());
        event.setEventDate(newEventForm.getEventDate());
        //TODO add remaining mappings
        return event;
    }

    public static EventDTO mapEventFormToDto(NewEventForm event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(event.getEventOwner());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setName(event.getName());
        eventDTO.setAcceptedParticipants(null);//fixme
        eventDTO.setWaitingList(null);//fixme
        return eventDTO;
    }
}
