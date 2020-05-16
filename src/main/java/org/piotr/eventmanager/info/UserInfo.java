package org.piotr.eventmanager.info;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UserInfo {

    private String uuid;
    private String userName;
    private String email;
}
