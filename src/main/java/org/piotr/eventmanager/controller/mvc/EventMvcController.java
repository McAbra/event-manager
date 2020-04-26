package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static org.piotr.eventmanager.mapper.EventMapper.mapEventFormToDto;

@Controller
public class EventMvcController {

    @Autowired
    private EventServiceImpl eventServiceImpl;

    @GetMapping("/add/event")
    public ModelAndView newEventForm() {
        ModelAndView mnv = new ModelAndView("newEventForm");
        mnv.addObject("eventForm", new NewEventForm());
        return mnv;
    }

    @PostMapping("/add/event")
    public String addedEvent(@Valid NewEventForm eventForm, Errors errors) {

        if (errors.hasErrors()){
            return errors.toString();
        }
        eventServiceImpl.addEvent(mapEventFormToDto(eventForm));
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "/success";
    }


}
