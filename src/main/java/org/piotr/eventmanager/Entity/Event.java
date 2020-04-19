package org.piotr.eventmanager.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.Entity.Utils.EventAccessType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    private EventAccessType accessType;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User eventOwner;


//    @ManyToMany (mappedBy = "events")
//    private List<User> participatns;

    public Event(String name, LocalDateTime eventDate, EventAccessType accessType) {
        this.name = name;
        this.eventDate = eventDate;
        this.accessType = accessType;
    }

}
