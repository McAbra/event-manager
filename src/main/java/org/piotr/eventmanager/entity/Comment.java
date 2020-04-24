package org.piotr.eventmanager.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "comment")
@NoArgsConstructor
@Data

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String event;
    private String user;
    private String text;

    public Comment(String event, String user, String text) {
        this.event = event;
        this.user = user;
        this.text = text;
    }

    @Getter
    @ManyToOne
    private Event commentedEvent;
}

