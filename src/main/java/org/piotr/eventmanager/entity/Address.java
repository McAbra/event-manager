package org.piotr.eventmanager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@NoArgsConstructor
@Embeddable
public class Address {

    private String city;
    private String street;
    private String number;

}
