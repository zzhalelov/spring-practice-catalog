package kz.runtime.spring_practice_catalog.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("Пользователь", "user"),
    MODER("Модератор", "moder"),
    ADMIN("Администратор", "admin");

    private final String displayName;
    private final String serviceName;
}