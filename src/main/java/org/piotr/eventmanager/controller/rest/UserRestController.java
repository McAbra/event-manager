package org.piotr.eventmanager.controller.rest;


import org.modelmapper.ModelMapper;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.form.UserRegisterForm;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/allusers")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();

        for( User u:userRepository.findAll()){
            userDTOS.add(mapUserToDto(u));
        }
        return userDTOS;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserRegisterForm userRegisterForm) {

        userRepository.save(userRegisterForm.toUser(passwordEncoder));
    }

    private UserDTO mapUserToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User mapDtoToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
