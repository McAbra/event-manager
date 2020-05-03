package org.piotr.eventmanager.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.entity.eventModels.EventAccessType;
import org.piotr.eventmanager.entity.eventModels.Address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "event")
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"eventOwner", "waitingList", "acceptedUsers", "comments"})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String uuid = UUID.randomUUID().toString();

    private String name;

    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    private EventAccessType accessType;

    @Embedded
    private Address eventAddress;

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

    @OneToMany(mappedBy = "commentedEvent")
    private Set<Comment> comments = new HashSet<>();


}
