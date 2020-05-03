package org.piotr.eventmanager.form;

import lombok.Data;
import org.piotr.eventmanager.entity.eventModels.Address;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;
import org.piotr.eventmanager.info.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class NewEventForm {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventDate;
    @NotNull
    private EventAccessType accessType;
    @NotNull
    private Address eventAddress = new Address();
    private UserInfo eventOwner;

}
