package kz.runtime.spring_practice_catalog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//Метод loadUserByUsername() принимает имя пользователя и отыскивает соответствующий объект UserDetails.
// Если учетная запись с таким именем пользователя не будет найдена,
// то метод сгенерирует исключение UsernameNotFoundException.
public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException;
}