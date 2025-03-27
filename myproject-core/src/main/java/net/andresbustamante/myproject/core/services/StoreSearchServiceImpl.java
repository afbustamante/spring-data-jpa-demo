package net.andresbustamante.myproject.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.StoreDto;
import net.andresbustamante.myproject.api.services.StoreSearchService;
import net.andresbustamante.myproject.core.dao.StoreDao;
import net.andresbustamante.myproject.core.entities.Store;
import net.andresbustamante.myproject.core.mappers.StoreMapper;

@Service
@Transactional(readOnly = true)
public class StoreSearchServiceImpl implements StoreSearchService {

    private final StoreDao storeDao;
    private final StoreMapper storeMapper;

    public StoreSearchServiceImpl(StoreDao storeDao, StoreMapper storeMapper) {
        this.storeDao = storeDao;
        this.storeMapper = storeMapper;
    }

    @Override
    public Collection<StoreDto> findStores() {
        List<Store> stores = storeDao.findAll();
        return storeMapper.map(stores);
    }
}
