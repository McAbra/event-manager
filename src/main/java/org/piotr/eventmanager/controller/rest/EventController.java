package org.piotr.eventmanager.controller.rest;


import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.mapper.UserMapper;
import org.piotr.eventmanager.repository.UserRepository;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.piotr.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/event")
public class EventController {

    @Autowired
    private EventServiceImpl eventServiceImpl;

    @Autowired
    private UserRepository userRepository; //fixme
    @Autowired
    private UserMapper userMapper; //fixme


    @GetMapping("/all")
    public Set<EventDTO> getAllEvents() {
        return eventServiceImpl.getAllEvents();
    }

    @PostMapping("/newevent")
    public void addEvent(@RequestBody EventDTO eventDTO, Principal principal) {

        eventServiceImpl.addEvent(eventDTO);
    }

    @GetMapping("/{accessType}")
    public Set<EventDTO> getEventsOfType(@PathVariable String accessType) {
        return eventServiceImpl.getEventsOfType(accessType);
    }

    @GetMapping("/id/{eventId}")
    public EventDTO getEvent(@PathVariable String eventId, Principal principal) {
        System.out.println(principal.getName());
        return eventServiceImpl.getEventById(eventId);
    }

    @GetMapping("/addusertoevent/{eventUuid}/{userUuid}")
    public void addUserToEvent(@PathVariable String eventUuid, @PathVariable String userUuid) {
        eventServiceImpl.addUserToEvent(eventUuid, userUuid);
    }

    @GetMapping("/uuid/{uuid}")
    public EventDTO findEventByUuid(@PathVariable String uuid) {
        return eventServiceImpl.findEventByUuid(uuid);
    }
}
