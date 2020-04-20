package org.piotr.eventmanager.form;

import org.piotr.eventmanager.entity.eventUtils.Address;
import org.piotr.eventmanager.entity.User;
import org.piotr.eventmanager.entity.eventUtils.EventAccessType;

import java.time.LocalDateTime;

public class NewEventForm {

    private String name;
    private LocalDateTime eventDate;
    private EventAccessType accessType;
    private Address eventAddress;
    private User eventOwner;
}
