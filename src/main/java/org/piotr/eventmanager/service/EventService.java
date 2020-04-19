package org.piotr.eventmanager.service;

import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.utils.EventAccessType;
import org.piotr.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    private List<Event> eventList = Arrays.asList(
            new Event("Event 1", formatDate("2018-12-30 19:30"), EventAccessType.PRIVATE)
            , new Event("Event 2", formatDate("2020-04-30 10:00"), EventAccessType.PUBLIC)
            , new Event("Event 3", formatDate("2020-05-01 12:00"), EventAccessType.PUBLIC));

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        for (Object e : eventRepository.findAll()
        ) {
            if (e instanceof Event) {
                events.add((Event) e);
            }
        }
        return eventList;
    }

    private LocalDateTime formatDate(String stringDate) {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(stringDate, dTF);
    }


}
