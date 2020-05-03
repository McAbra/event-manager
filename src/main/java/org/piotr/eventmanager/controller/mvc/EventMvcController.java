package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.mapper.EventMapper;
import org.piotr.eventmanager.repository.UserRepository;
import org.piotr.eventmanager.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EventMvcController {

    @Autowired
    private EventServiceImpl eventServiceImpl;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventMapper eventMapper;

    @GetMapping("/add/event")
    public ModelAndView newEventForm() {
        ModelAndView mnv = new ModelAndView("newEventForm");
        mnv.addObject("eventForm", new NewEventForm());
        return mnv;
    }

//    @PostMapping("/add/event")
//    public String addedEvent(@Valid NewEventForm eventForm, Errors errors, Principal principal) {
//
//        if (errors.hasErrors()){
//            return errors.toString();
//        }
//        eventServiceImpl.addEvent(eventMapper.mapEventFormToDto(eventForm));
//        return "redirect:/success";
//    }



    @GetMapping("/success")
    public String success() {
        return "/success";
    }


}
