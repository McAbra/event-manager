package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserEntity> findByUserName(String userName);
    boolean existsByUserName(String userName);

}
