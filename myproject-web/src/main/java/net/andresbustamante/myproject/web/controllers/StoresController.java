package net.andresbustamante.myproject.web.controllers;

import java.util.Collection;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.myproject.api.model.StoreDto;
import net.andresbustamante.myproject.api.services.StoreSearchService;
import net.andresbustamante.myproject.web.dto.StorePage;
import net.andresbustamante.myproject.web.mappers.StoreDtoMapper;

@RestController
@RequestMapping("/api")
public class StoresController extends AbstractController implements StoresApi {

    private final StoreSearchService storeSearchService;
    private final StoreDtoMapper storeDtoMapper;

    public StoresController(final ObjectMapper objectMapper, final HttpServletRequest request,
            final StoreSearchService storeSearchService, final StoreDtoMapper storeDtoMapper) {
        super(objectMapper, request);
        this.storeSearchService = storeSearchService;
        this.storeDtoMapper = storeDtoMapper;
    }

    @Override
    public ResponseEntity<StorePage> findStores() {
        Collection<StoreDto> stores = storeSearchService.findStores();

        StorePage storePage = new StorePage();
        storePage.setPage(0);
        storePage.setNumberOfElements(stores.size());
        storePage.setTotalElements(stores.size());
        storePage.setStores(storeDtoMapper.map(stores));

        return ResponseEntity.ok(storePage);
    }
}
