package org.piotr.eventmanager.Controller;


import org.piotr.eventmanager.Entity.Event;
import org.piotr.eventmanager.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;


    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/events/newevent")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }
}
