package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUuid(String uuid);

    User findByUserName(String name);

}
