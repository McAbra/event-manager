package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.piotr.eventmanager.entity.Comment;
import org.piotr.eventmanager.entity.eventModels.Address;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;
import org.piotr.eventmanager.info.CommentInfo;
import org.piotr.eventmanager.info.UserInfo;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EventDTO {


    private String uuid;
    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private Address eventAddress;
    private UserInfo eventOwner;
    private Set<UserInfo> waitingList;
    private Set<UserInfo> acceptedUsers;
    private Set<CommentInfo> comments;
}
