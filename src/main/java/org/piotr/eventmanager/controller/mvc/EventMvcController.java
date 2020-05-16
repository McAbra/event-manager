package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.mapper.EventMapper;
import org.piotr.eventmanager.repository.UserRepository;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EventMvcController {

    @Autowired
    private EventServiceImpl eventServiceImpl;

    @Autowired
    private UserRepository userRepository;
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
        eventServiceImpl.addEvent(eventMapper.mapEventFormToDto(newEventForm));

        return "redirect:/";
    }

    @GetMapping("/event/all")
    public ModelAndView getAllEvents() {
        ModelAndView mnv = new ModelAndView("events");
        mnv.addObject("events", eventServiceImpl.getAllEvents());
        return mnv;
    }



    @GetMapping("/success")
    public String success() {
        return "/success";
    }


}
