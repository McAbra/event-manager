package org.piotr.eventmanager.service;

import org.piotr.eventmanager.form.UserRegisterForm;

public interface UserService {
    void createUser(UserRegisterForm userRegisterForm);
}
