package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.form.NewEventForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.piotr.eventmanager.mapper.UserMapper.mapUserToDto;

@Service
public class EventMapper {

    public static EventDTO mapEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(mapUserToDto(event.getEventOwner()));
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setName(event.getName());
        eventDTO.setUuid(event.getUuid());
        Set<UserDTO> acceptedUsers = new HashSet<>();
        for(User u : event.getAcceptedUsers()){
            acceptedUsers.add(mapUserToDto(u));
        }
        eventDTO.setAcceptedUsers(acceptedUsers);


        eventDTO.setAcceptedUsers(event.getAcceptedUsers());//fixme
        eventDTO.setWaitingList(event.getWaitingList());//fixme
        return eventDTO;
    }

    public static List<EventDTO> mapEventListToDtoList(Iterable<Event> events) {
        List<EventDTO> dtos = new ArrayList<>();
        for (Object e : events) {
            dtos.add(mapEventToDto((Event) e));
        }
        return dtos;
    }

    public static Event mapEventDtoToNewEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setAccessType(eventDTO.getAccessType());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventOwner(eventDTO.getEventOwner());
        event.setName(eventDTO.getName());
        event.setEventAddress(eventDTO.getEventAddress());
        event.setWaitingList(eventDTO.getWaitingList());
        event.setAcceptedUsers(eventDTO.getAcceptedUsers());
        return event;
    }

//    public static Event mapEventFormToNewEvent(NewEventForm newEventForm) {
//        Event event = new Event();
//        event.setName(newEventForm.getName());
//        event.setAccessType(newEventForm.getAccessType());
//        event.setEventAddress(newEventForm.getEventAddress());
//        event.setEventDate(newEventForm.getEventDate());
//        //TODO add remaining mappings
//        return event;
//    }

    public static Event mapEventDtoToExistingEvent(Event event, EventDTO eventDTO) {
        event.setName(eventDTO.getName());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventAddress(eventDTO.getEventAddress());
        event.setAccessType(eventDTO.getAccessType());
        event.setAcceptedUsers(eventDTO.getAcceptedUsers());
        event.setWaitingList(eventDTO.getWaitingList());
        event.setComments(eventDTO.getComments());
        return event;
    }

    public static EventDTO mapEventFormToDto(NewEventForm event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventOwner(event.getEventOwner());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setName(event.getName());
        //eventDTO.setAcceptedUsers(null);//fixme
        //eventDTO.setWaitingList(null);//fixme
        return eventDTO;
    }
}
