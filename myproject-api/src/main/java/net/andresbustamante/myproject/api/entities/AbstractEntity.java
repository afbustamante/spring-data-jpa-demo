package net.andresbustamante.myproject.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Getter @Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, VersionEntityListener.class})
public abstract class AbstractEntity implements Serializable {

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    protected String creator;

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    protected Instant creationDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    protected String modifier;

    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    protected Instant modificationDate;

    @Version
    protected Integer version;
}
