package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByEventDate(LocalDateTime dateTime);

    List<Event> findAllByAccessType(String accessType);

    List<Event> findAllByAccessType(EventAccessType eventAccessType);

    Event findByUuid(String uuid);

    Set<Event> findByEventOwner(String ownerName);

}
