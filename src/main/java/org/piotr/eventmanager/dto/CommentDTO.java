package org.piotr.eventmanager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CommentDTO {

    private String uuid;
    private UserDTO author;
    private String text;
    private EventDTO commentedEvent;

}
