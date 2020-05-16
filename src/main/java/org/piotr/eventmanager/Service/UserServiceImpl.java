package org.piotr.eventmanager.service;

import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.exception.UserExistsException;
import org.piotr.eventmanager.form.UserRegisterForm;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public Set<User> getAllUsersByName(Set<String> names) {
        Set<User> users = new HashSet<>();

        for (String name: names
        ) {
            users.add(userRepository.findByUserName(name));
        }
        return users;
    }

    @Override
    public User getUserByName(String eventOwner) {
        return userRepository.findByUserName(eventOwner);
    }


}
