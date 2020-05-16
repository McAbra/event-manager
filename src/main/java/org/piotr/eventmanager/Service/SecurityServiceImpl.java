package org.piotr.eventmanager.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Override
    public String getLoginOfCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
