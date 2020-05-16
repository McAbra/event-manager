package org.piotr.eventmanager.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.Comment;
import org.piotr.eventmanager.entity.Event;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserMapper {


    public UserDTO mapUserToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getUuid());
        userDTO.setLogin(user.getLogin());
        userDTO.setUserName(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserWaitingList(user.getUserWaitingList().stream().map(Event::getName).collect(Collectors.toSet()));
        userDTO.setEvents(user.getEvents().stream().map(Event::getName).collect(Collectors.toSet()));
        userDTO.setOwnedEvents(user.getOwnedEvents().stream().map(Event::getName).collect(Collectors.toSet()));
        userDTO.setComments(user.getComments().stream().map(Comment::getUuid).collect(Collectors.toSet()));
        return userDTO;
    }
}
