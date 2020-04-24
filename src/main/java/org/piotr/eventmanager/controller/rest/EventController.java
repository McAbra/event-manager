package org.piotr.eventmanager.controller.rest;


import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventServiceImpl;


    @GetMapping("/events")
    public List<EventDTO> getAllEvents() {
        return eventServiceImpl.getAllEvents();
    }

    @PostMapping("/events/newevent")
    public void addEvent(@RequestBody EventDTO eventDTO) {
        eventServiceImpl.addEvent(eventDTO);
    }

    @GetMapping("/events/{accessType}")
    public List<EventDTO> getEventsOfType(@PathVariable String accessType) {
        return eventServiceImpl.getEventsOfType(accessType);
    }

    @GetMapping("/event/{eventId}")
    public EventDTO getEvent(@PathVariable String eventId) {
        return eventServiceImpl.getEventById(eventId);
    }
}
