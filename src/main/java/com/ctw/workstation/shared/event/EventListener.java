package com.ctw.workstation.shared.event;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class EventListener<E> {

    @PrePersist
    public void prePersist(E entity) {
        setField(entity, "createdAt", LocalDateTime.now());
        setField(entity, "modifiedAt", LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(E entity) {
        setField(entity, "modifiedAt", LocalDateTime.now());
    }

    private void setField(E entity, String fieldName, LocalDateTime value) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(entity, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
