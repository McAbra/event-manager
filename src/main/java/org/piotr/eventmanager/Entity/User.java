package org.piotr.eventmanager.Entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "user_")
@ToString
public class User {

    @Id
    private long id;
    private String name;

    @Getter
    @ManyToMany
    private List<Event> events = new ArrayList<>();

    public User() {
    }

    public User (String name) {
        this.name = name;
    }

}


