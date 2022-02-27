package net.andresbustamante.myproject.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, VersionEntityListener.class})
public abstract class AbstractEntity implements Serializable {

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    protected String creator;

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    protected LocalDateTime creationDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    protected String modifier;

    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    protected LocalDateTime modificationDate;

    @Version
    protected Integer version;
}
