package org.piotr.eventmanager.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.dto.UserDTO;


@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CommentInfo {

    private String uuid;
    private UserInfo author;
    private String text;
}
