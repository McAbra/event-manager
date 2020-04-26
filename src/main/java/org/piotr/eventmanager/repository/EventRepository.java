package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.eventUtils.EventAccessType;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByEventDate(LocalDateTime dateTime);

    List<Event> findAllByAccessType(String accessType);

    List<Event> findAllByAccessType(EventAccessType eventAccessType);



}
