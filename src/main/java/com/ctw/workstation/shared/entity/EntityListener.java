package com.ctw.workstation.shared.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class EntityListener {

    @PrePersist
    void onCreate(AbstractTimeEntity entity) {
        entity.createdAt = LocalDateTime.now();
        entity.modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(AbstractTimeEntity entity) {
        entity.modifiedAt = LocalDateTime.now();
    }
}
