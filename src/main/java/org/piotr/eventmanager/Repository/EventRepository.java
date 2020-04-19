package org.piotr.eventmanager.Repository;

import org.piotr.eventmanager.Entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
