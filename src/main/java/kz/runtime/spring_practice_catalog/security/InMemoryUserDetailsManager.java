package kz.runtime.spring_practice_catalog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsManager implements UserDetailsService {
    public InMemoryUserDetailsManager(List<UserDetails> usersList) {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}