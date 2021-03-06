package org.piotr.eventmanager.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.eventUtils.Address;
import org.piotr.eventmanager.entity.eventUtils.EventAccessType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "event")
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime eventDate;

    @Embedded
    private Address eventAddress;

    @Enumerated(EnumType.STRING)
    private EventAccessType accessType;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User eventOwner;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "event_user_waitingList",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> waitingList = new HashSet<>();


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "event_user_acceptedUsers",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> acceptedUsers = new HashSet<>();

    public Event(String name, LocalDateTime eventDate, EventAccessType accessType) {
        this.name = name;
        this.eventDate = eventDate;
        this.accessType = accessType;
    }

    @OneToMany(mappedBy = "commentedEvent")
    private Set<Comment> comments = new HashSet<>();


}
