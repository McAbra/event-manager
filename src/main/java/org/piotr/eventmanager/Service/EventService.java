package org.piotr.eventmanager.Service;

import org.piotr.eventmanager.Entity.Event;
import org.piotr.eventmanager.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}
