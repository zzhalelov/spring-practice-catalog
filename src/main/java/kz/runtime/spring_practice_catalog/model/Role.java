package kz.runtime.spring_practice_catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER("user", "Пользователь"),
    MODERATOR("moder", "Модератор"),
    ADMINISTRATOR("admin", "Администратор");

    private final String serviceName;
    private final String displayName;
}