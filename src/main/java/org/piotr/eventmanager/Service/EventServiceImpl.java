package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.mapper.EventMapper;
import org.piotr.eventmanager.repository.EventRepository;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Service
public class EventServiceImpl implements EventService {

//    private List<Event> eventList = Arrays.asList(
//            new Event("Event 1", formatDate("2018-12-30 19:30"), EventAccessType.PRIVATE)
//            , new Event("Event 2", formatDate("2020-04-30 10:00"), EventAccessType.PUBLIC)
//            , new Event("Event 3", formatDate("2020-05-01 12:00"), EventAccessType.PUBLIC));

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private SecurityService securityService;

    @Override
    public String addEvent(EventDTO eventDTO) {
        eventDTO.setEventOwner(userRepository.findByLogin(securityService.getLoginOfCurrentUser()).getUsername());
        Event event = eventMapper.mapDtoToEvent(eventDTO);
        eventRepository.save(event);
        return event.getUuid();
    }

    @Override
    public Set<EventDTO> getAllEvents() {

        return eventMapper.mapEventsToDtos(eventRepository.findAll());
    }

    @Override
    public Set<EventDTO> getEventsByDate(LocalDateTime date) {
        return null;
        //return mapEventListToDtoList(eventRepository.findByEventDate(date));
    }

    @Override
    public Set<EventDTO> getEventsOfType(String eventType) {
        return null;
        //return mapEventListToDtoList(eventRepository.findAllByAccessType(EventAccessType.valueOf(eventType.toUpperCase())));
    }

    public EventDTO getEventById(String eventId) {
        return eventMapper.mapEventToDto(eventRepository.findById(Long.valueOf(eventId)).get());
    }

    public void addUserToEvent(String eventUuid, String userUuid) {
        User user = userRepository.findByUuid(userUuid);
        Event event = eventRepository.findByUuid(eventUuid);
        user.getEvents().add(event);
        event.getAcceptedUsers().add(user);
        userRepository.save(user);
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(EventDTO eventDTO) {

        eventRepository.save(eventMapper.mapDtoToEvent(eventDTO));
    }


    @Override
    public void addUserToWaitingList(String eventUuid) {
        System.out.println(eventUuid);
        Event event = eventRepository.findByUuid(eventUuid);
        event.getWaitingList().add(userRepository.findByLogin(securityService.getLoginOfCurrentUser()));
        eventRepository.save(event);
    }

    @Override
    public void acceptUser(UserDTO userDTO, EventDTO eventDTO) {
        Event event = eventRepository.findByUuid(eventDTO.getUuid());
        User user = userRepository.findByUuid(userDTO.getUuid());
        event.getWaitingList().remove(user);
        event.getAcceptedUsers().add(user);
        user.getEvents().add(event);
        userRepository.save(user);
        eventRepository.save(event);
    }

    @Override
    public EventDTO findEventByUuid(String uuid) {
        return eventMapper.mapEventToDto(eventRepository.findByUuid(uuid));
    }
}
