package com.ctw.workstation.shared.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AbstractTimeEntity extends AbstractEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    public LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_AT")
    public LocalDateTime modifiedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
