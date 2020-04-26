package org.piotr.eventmanager.Service;

import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.UserEntity;
import org.piotr.eventmanager.exception.UserExistsException;
import org.piotr.eventmanager.form.UserRegisterForm;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserRegisterForm userRegisterForm) {

        if(userRepository
                .existsByUserName(userRegisterForm.getUserName())) {
            throw new UserExistsException("User already exists");
        }

        UserEntity user = new UserEntity(UserRegisterForm.getLogin(),
                passwordEncoder.encode(userRegisterForm.getPassword()),
                userRegisterForm.getUserName());
        UserRepository.save(user);
    }
}
