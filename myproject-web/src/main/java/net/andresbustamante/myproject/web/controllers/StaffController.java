package net.andresbustamante.myproject.web.controllers;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

import net.andresbustamante.myproject.api.exceptions.ApplicationException;
import net.andresbustamante.myproject.api.exceptions.FunctionalException;
import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.api.services.StaffManagementService;
import net.andresbustamante.myproject.api.services.StaffSearchService;
import net.andresbustamante.myproject.web.dto.StaffForm;
import net.andresbustamante.myproject.web.dto.StaffPage;
import net.andresbustamante.myproject.web.mappers.StaffDtoMapper;
import net.andresbustamante.myproject.web.mappers.StaffFormMapper;

@RestController
@RequestMapping("/api")
public class StaffController extends AbstractController implements StaffApi {

    private final StaffSearchService staffSearchService;
    private final StaffManagementService staffManagementService;
    private final StaffDtoMapper staffDtoMapper;
    private final StaffFormMapper staffFormMapper;

    public StaffController(final ObjectMapper objectMapper, final HttpServletRequest request,
            final StaffSearchService staffSearchService, final StaffManagementService staffManagementService,
            final StaffDtoMapper staffDtoMapper,
            final StaffFormMapper staffFormMapper) {
        super(objectMapper, request);

        this.staffSearchService = staffSearchService;
        this.staffManagementService = staffManagementService;
        this.staffDtoMapper = staffDtoMapper;
        this.staffFormMapper = staffFormMapper;
    }

    @Override
    public ResponseEntity<StaffPage> findStaff() {
        Collection<StaffDto> staff = staffSearchService.fetchActiveStaff();

        StaffPage staffPage = new StaffPage();
        staffPage.setPage(0);
        staffPage.setNumberOfElements(staff.size());
        staffPage.setTotalElements(staff.size());
        staffPage.setStaff(staffDtoMapper.map(staff));

        return ResponseEntity.ok(staffPage);
    }

    @Override
    public ResponseEntity<Void> createStaff(StaffForm staffForm) {
        try {
            short staffId = staffManagementService.createStaff(staffFormMapper.map(staffForm), getUserContext());

            return ResponseEntity.created(URI.create(String.format("/api/staff/%d", staffId))).build();
        } catch (FunctionalException e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        } catch (ApplicationException e) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
