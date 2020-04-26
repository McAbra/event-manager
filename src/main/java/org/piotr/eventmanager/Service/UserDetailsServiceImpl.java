package org.piotr.eventmanager.Service;

import org.piotr.eventmanager.entity.UserEntity;
import org.piotr.eventmanager.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }
}
