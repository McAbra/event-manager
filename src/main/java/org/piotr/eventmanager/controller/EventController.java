package org.piotr.eventmanager.controller;


import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.piotr.eventmanager.mapper.EventMapper.mapEventDtoToEvent;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;


    @GetMapping("/events")
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/events/newevent")
    public void addEvent(@RequestBody EventDTO eventDTO) {
        eventService.addEvent(mapEventDtoToEvent(eventDTO));
    }
}
