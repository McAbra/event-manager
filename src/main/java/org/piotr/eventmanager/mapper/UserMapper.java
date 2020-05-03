package org.piotr.eventmanager.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO mapUserToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public UserInfo mapUserToInfo(User user) {
        return modelMapper.map(user, UserInfo.class);
    }

//    public static UserDTO mapUserToDto(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUuid(user.getUuid());
//        userDTO.setLogin(user.getLogin());
//        userDTO.setUserName(user.getUserName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setUserWaitingList(mapEventSetToDto(user.getUserWaitingList()));
//        userDTO.setEvents(mapEventSetToDto(user.getEvents()));
//        userDTO.setOwnedEvents(mapEventSetToDto(user.getOwnedEvents()));
//        userDTO.setComments(mapCommentSetToDto(user.getComments()));
//        return userDTO;
//    }

//    public static Set<UserDTO> mapUserSetToDto(Iterable<User> users) {
//        Set<UserDTO> dtos2 = new HashSet<>();
//        for (User u : users) {
//            dtos2.add(mapUserToDto(u));
//        }
//        return dtos2;
//    }
//
//    public static User mapUserDtoToNewUser(UserDTO userDTO) {
//        User user = new User();
//        user.setLogin(userDTO.getLogin());
//        user.setUserName(userDTO.getUserName());
//        user.setEmail(userDTO.getEmail());
//        return user;
//    }
}
