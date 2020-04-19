package org.piotr.eventmanager.Repository;

import org.piotr.eventmanager.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
