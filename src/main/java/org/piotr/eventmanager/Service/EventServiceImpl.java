package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.mapper.EventMapper;
import org.piotr.eventmanager.repository.EventRepository;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Service
public class EventServiceImpl implements org.piotr.eventmanager.service.EventService {

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

    @Override
    public void addEvent(EventDTO eventDTO) {

        //userRepository.save(eventDTO.getEventOwner());

        eventRepository.save(eventMapper.mapDtoToEvent(eventDTO));
    }

    @Override
    public List<EventDTO> getAllEvents() {

        return eventMapper.mapEventsToDtos(eventRepository.findAll());
    }

    @Override
    public List<EventDTO> getEventsByDate(LocalDateTime date) {
        return null;
        //return mapEventListToDtoList(eventRepository.findByEventDate(date));
    }

    @Override
    public List<EventDTO> getEventsOfType(String eventType) {
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
    public void addUserToWaitingList(UserDTO userDTO, EventDTO eventDTO) {
        Event event = eventRepository.findByUuid(eventDTO.getUuid());
        event.getWaitingList().add(userRepository.findByUuid(userDTO.getUuid()));
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
