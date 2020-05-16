package org.piotr.eventmanager.entity;

import lombok.*;
import org.piotr.eventmanager.entity.userModels.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity(name = "user")
@Data
@ToString
@NoArgsConstructor(force = true)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uuid; //= UUID.randomUUID().toString();
    private String login;
    private String password;
    private String userName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;

    private boolean enabled = true;

    @ManyToMany(mappedBy = "waitingList")
    private Set<Event> userWaitingList = new HashSet<>();

    @ManyToMany(mappedBy = "acceptedUsers")
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "eventOwner")
    private Set<Event> ownedEvents = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments = new HashSet<>();

    public User(String uuid, String login, String password, String userName, String email){
        this.uuid = uuid;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.email = email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


