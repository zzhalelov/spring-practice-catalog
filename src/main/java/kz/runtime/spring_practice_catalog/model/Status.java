package kz.runtime.spring_practice_catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    CREATED("Создано"),
    IN_DELIVERY("В пути"),
    DELIVERED("Доставлено");

    private final String displayName;
}