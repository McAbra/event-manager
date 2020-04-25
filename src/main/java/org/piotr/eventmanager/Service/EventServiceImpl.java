package org.piotr.eventmanager.service;

import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.eventUtils.EventAccessType;
import org.piotr.eventmanager.repository.EventRepository;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.piotr.eventmanager.mapper.EventMapper.*;

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

    @Override
    public void addEvent(EventDTO eventDTO) {

        userRepository.save(eventDTO.getEventOwner());

        eventRepository.save(mapEventDtoToEvent(eventDTO));
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return mapEventListToDtoList(eventRepository.findAll());
    }

    @Override
    public List<EventDTO> getEventsByDate(LocalDateTime date) {
        return mapEventListToDtoList(eventRepository.findByEventDate(date));
    }

    @Override
    public List<EventDTO> getEventsOfType(String eventType) {
        return mapEventListToDtoList(eventRepository.findAllByAccessType(EventAccessType.valueOf(eventType.toUpperCase())));
    }

    public EventDTO getEventById(String eventId) {
        return mapEventToDto(eventRepository.findById(Long.valueOf(eventId)).get());
    }

    private LocalDateTime formatDate(String stringDate) {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(stringDate, dTF);
    }




}
