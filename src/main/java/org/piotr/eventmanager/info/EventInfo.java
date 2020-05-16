package org.piotr.eventmanager.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.dto.UserDTO;
import org.piotr.eventmanager.entity.eventModels.Address;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EventInfo {

    private String uuid;
    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private Address eventAddress;
    private UserInfo eventOwner;
}
