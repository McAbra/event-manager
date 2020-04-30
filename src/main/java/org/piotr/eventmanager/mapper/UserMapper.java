package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class UserMapper {

    public static UserDTO mapUserToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUuid(user.getUuid());
        return userDTO;
    }

    public static List<UserDTO> mapEventListToDtoList(Iterable<User> users) {
        List<UserDTO> dtos2 = new ArrayList<>();
        for (User u : users) {
            dtos2.add(mapUserToDto(u));
        }
        return dtos2;
    }

    public static User mapUserDtoToNewUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
