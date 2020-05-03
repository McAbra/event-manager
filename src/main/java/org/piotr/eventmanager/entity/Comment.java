package org.piotr.eventmanager.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "comment")
@NoArgsConstructor
@Data

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String uuid = UUID.randomUUID().toString();

    @ManyToOne
    private User author;

    private String text;

    @ManyToOne
    private Event commentedEvent;
}

