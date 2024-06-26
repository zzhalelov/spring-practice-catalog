package kz.runtime.spring_practice_catalog.service.impl;

import kz.runtime.spring_practice_catalog.model.Role;
import kz.runtime.spring_practice_catalog.model.User;
import kz.runtime.spring_practice_catalog.repository.UserRepository;
import kz.runtime.spring_practice_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Override
    public User getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return userRepository
                .findByLogin(authentication.getName())
                .orElseThrow();
    }
}