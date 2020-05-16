package org.piotr.eventmanager.service;

import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.form.UserRegisterForm;

import java.util.Set;

public interface UserService {
    void createUser(UserRegisterForm userRegisterForm);

    Set<User> getAllUsersByName(Set<String> names);

    User getUserByName(String eventOwner);
}
