package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.StoreDto;

public interface StoreSearchService {

    Collection<StoreDto> findStores();
}
