package com.lilium.jpatutorial.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class DistributedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private Long createdTimestamp;

    @Column(nullable = false)
    private Long modifiedTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Long getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Long modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
}
