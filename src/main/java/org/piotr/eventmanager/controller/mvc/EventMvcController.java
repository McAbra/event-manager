package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.form.NewEventForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class EventMvcController {

    @GetMapping("/add/event")
    public ModelAndView newEventForm() {
        ModelAndView mnv = new ModelAndView("newEventForm");
        mnv.addObject("name", "Janusz");
        mnv.addObject("eventForm", new NewEventForm());
        return mnv;
    }

    @PostMapping("/add/event")
    public String addedEvent(@Valid NewEventForm eventForm, Errors errors) {

        if (errors.hasErrors()){
            return errors.toString();
        }
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "/success";
    }


}
