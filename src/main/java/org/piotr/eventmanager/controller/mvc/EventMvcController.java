package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.mapper.EventMapper;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.piotr.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EventMvcController {

    @Autowired
    private EventServiceImpl eventServiceImpl;
    @Autowired
    private UserService userService;
    @Autowired
    private EventMapper eventMapper;

    @GetMapping("/event/add")
    public ModelAndView newEventForm() {
        ModelAndView mnv = new ModelAndView("neweventform");
        mnv.addObject("eventForm", new NewEventForm());
        return mnv;
    }

    @PostMapping("/event/add")
    public String addNewEvent(NewEventForm newEventForm) {

        String eventUuid = eventServiceImpl.addEvent(eventMapper.mapEventFormToDto(newEventForm));

        return "redirect:/event/" + eventUuid + "/details";
    }

    @GetMapping("/event/all")
    public ModelAndView getAllEvents() {
        ModelAndView mnv = new ModelAndView("events");
        mnv.addObject("events", eventServiceImpl.getAllEvents());
        return mnv;
    }

    @GetMapping("/event/{uuid}/details")
    public ModelAndView eventDetails(@PathVariable String uuid) {
        ModelAndView mnv = new ModelAndView("eventdetails");
        mnv.addObject("event", eventServiceImpl.findEventByUuid(uuid));
        return mnv;
    }

    @GetMapping("/event/{uuid}/adduser")
    public String addUserToEvent(@PathVariable String uuid) {
    eventServiceImpl.addUserToWaitingList(uuid);
        return "/success";
    }


    @GetMapping("/success")
    public String success() {

        return "/success";
    }


}
