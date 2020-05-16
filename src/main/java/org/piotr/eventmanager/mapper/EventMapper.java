package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Comment;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.service.CommentService;
import org.piotr.eventmanager.service.EventService;
import org.piotr.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventMapper {

    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    public EventDTO mapEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setUuid(event.getUuid());
        eventDTO.setName(event.getName());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setAccessType(event.getAccessType());
        eventDTO.setEventAddress(event.getEventAddress());
        eventDTO.setEventOwner(event.getEventOwner().getUsername());
        eventDTO.setWaitingList(event.getWaitingList().stream().map(User::getUsername).collect(Collectors.toSet()));
        eventDTO.setAcceptedUsers(event.getAcceptedUsers().stream().map(User::getUsername).collect(Collectors.toSet()));
        eventDTO.setCommentsUuid(event.getComments().stream().map(Comment::getUuid).collect(Collectors.toSet()));
        return eventDTO;

    }

    public EventDTO mapEventFormToDto(NewEventForm eventForm) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(eventForm.getName());
        eventDTO.setEventDate(eventForm.getEventDate());
        eventDTO.setAccessType(eventForm.getAccessType());
        eventDTO.setEventAddress(eventForm.getEventAddress());
        eventDTO.setEventOwner(eventForm.getEventOwner());
        return eventDTO;
    }

    public Event mapDtoToEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setEventDate(eventDTO.getEventDate());
        event.setAccessType(eventDTO.getAccessType());
        event.setEventAddress(eventDTO.getEventAddress());
        event.setEventOwner(userService.getUserByName(eventDTO.getEventOwner()));
        return event;
    }


    public Set<EventDTO> mapEventsToDtos(Iterable<Event> events) {
        Set<EventDTO> eventDTOS = new HashSet<>();
        for (Event event : events
        ) {
            eventDTOS.add(mapEventToDto(event));
        }
        return eventDTOS;
    }


}
