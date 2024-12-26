package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.ActorCreationDto;

public interface ActorManagementService {

    /**
     * Creates a new actor in database.
     *
     * @param actorData Data to use to create the new actor
     * @return New actor's ID
     */
    short createActor(ActorCreationDto actorData);
}
