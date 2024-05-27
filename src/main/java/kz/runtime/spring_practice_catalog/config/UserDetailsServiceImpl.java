package kz.runtime.spring_practice_catalog.config;

import kz.runtime.spring_practice_catalog.exception.EntityNotFoundException;
import kz.runtime.spring_practice_catalog.model.User;
import kz.runtime.spring_practice_catalog.repository.UserRepository;
import kz.runtime.spring_practice_catalog.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByLogin(username)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с login = " + username + " не существует"));

        return new UserDetailsImpl(user);
    }
}
