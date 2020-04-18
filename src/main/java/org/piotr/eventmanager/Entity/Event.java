package org.piotr.eventmanager.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.piotr.eventmanager.Entity.Utils.EventAccessType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime eventDate;

    @Enumerated
    private EventAccessType accesType;


//    @ManyToMany (mappedBy = "events")
//    private List<User> participatns;

}
