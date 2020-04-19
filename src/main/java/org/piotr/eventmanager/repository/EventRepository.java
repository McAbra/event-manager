package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
