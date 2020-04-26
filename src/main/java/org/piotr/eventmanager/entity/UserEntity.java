package org.piotr.eventmanager.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String userName;
    private String email;

    @ManyToMany(mappedBy = "waitingList")
    private Set<Event> userWaitingList = new HashSet<>();

    public UserEntity(String login, String password, String userName, String email) {

        this.login = login;
        this.password = password;
        this.userName = userName;
        this.email = email;
    }

    @Getter
    @ManyToMany(mappedBy = "acceptedUsers")
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "eventOwner")
    private Set<Event> ownedEvents = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity (String name) {
        this.userName = name;
    }
}
