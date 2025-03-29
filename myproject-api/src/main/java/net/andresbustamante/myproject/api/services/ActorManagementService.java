package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.ActorCreationDto;
import net.andresbustamante.myproject.api.util.UserContext;

public interface ActorManagementService {

    /**
     * Creates a new actor in database.
     *
     * @param actorData Data to use to create the new actor
     * @param ctx Context of the current user.
     * @return New actor's ID
     */
    short createActor(ActorCreationDto actorData, UserContext ctx);
}
