package net.andresbustamante.myproject.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.myproject.api.model.ActorCreationDto;
import net.andresbustamante.myproject.api.services.ActorManagementService;
import net.andresbustamante.myproject.core.dao.ActorDao;
import net.andresbustamante.myproject.core.entities.Actor;

@Service
@Slf4j
public class ActorManagementServiceImpl implements ActorManagementService {

    private final ActorDao actorDao;

    public ActorManagementServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    @Transactional
    public short createActor(final ActorCreationDto actorData) {
        Actor actor = new Actor();
        actor.setFirstName(actorData.firstName());
        actor.setLastName(actorData.lastName());

        actor = actorDao.save(actor);

        log.info("New actor {} {} created with the ID {}", actor.getFirstName(), actor.getLastName(), actor.getId());

        return actor.getId();
    }
}
