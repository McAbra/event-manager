package org.piotr.eventmanager.service;

import org.piotr.eventmanager.exception.UserExistsException;
import org.piotr.eventmanager.form.UserRegisterForm;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserRegisterForm userRegisterForm) {
        if(userRepository
                .existsByUserName(userRegisterForm.getUserName())){
            throw new UserExistsException(userRegisterForm.getUserName());
        }
        userRepository.save(userRegisterForm.toUser(passwordEncoder));
    }
}
