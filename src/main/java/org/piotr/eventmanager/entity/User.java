package org.piotr.eventmanager.entity;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "user")
@Data
@ToString
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String userName;
    private String email;

    @ManyToMany(mappedBy = "waitingList")
    private Set<Event> userWaitingList = new HashSet<>();

    public User(String login, String password, String userName, String email) {

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

    public User() {
    }

    public User (String name) {
        this.userName = name;
    }

}


