package net.andresbustamante.myproject.api.entities;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class VersionEntityListener {

    @PrePersist
    public void prePersist(AbstractEntity entity) {
        if (entity != null) {
            entity.setVersion(0);
        }
    }

    @PreUpdate
    public void preUpdate(AbstractEntity entity) {
        if (entity != null) {
            entity.setVersion(entity.getVersion() != null ? entity.getVersion() + 1 : 0);
        }
    }

}