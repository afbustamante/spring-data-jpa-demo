package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AbstractAuditableEntity implements Serializable {

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String creator;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant creationDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifier;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Instant modificationDate;
}
