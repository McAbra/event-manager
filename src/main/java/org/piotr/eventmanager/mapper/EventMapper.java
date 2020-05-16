package org.piotr.eventmanager.mapper;

import org.modelmapper.ModelMapper;
import org.piotr.eventmanager.dto.EventDTO;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.form.NewEventForm;
import org.piotr.eventmanager.info.EventInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventMapper {

    @Autowired
    private ModelMapper modelMapper;


    public EventDTO mapEventToDto(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    public Event mapDtoToEvent(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }

    public List<EventDTO> mapEventsToDtos(Iterable<Event> events) {
        List<EventDTO> eventDTOS = new ArrayList<>();
        for (Event e : events) {
            eventDTOS.add(modelMapper.map(e, EventDTO.class));
        }
        return eventDTOS;
    }

    public EventInfo mapEventToInfo(Event event) {
        return modelMapper.map(event, EventInfo.class);
    }


    public Event mapEventFormToEvent(NewEventForm newEventForm) {
        return modelMapper.map(newEventForm, Event.class);
    }
    public EventDTO mapEventFormToDto(NewEventForm newEventForm){
        return modelMapper.map(newEventForm, EventDTO.class);
    }


}
