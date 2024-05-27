package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.User;

public interface UserService {
    void create(User user);

    User getUser();
}