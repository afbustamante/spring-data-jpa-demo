package net.andresbustamante.myproject.web.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.api.services.StaffManagementService;
import net.andresbustamante.myproject.api.services.StaffSearchService;
import net.andresbustamante.myproject.web.dto.StaffForm;
import net.andresbustamante.myproject.web.mappers.StaffFormMapper;

@RestController
@RequestMapping("/staff")
public class StaffController extends AbstractController {

    private final StaffSearchService staffSearchService;
    private final StaffManagementService staffManagementService;
    private final StaffFormMapper staffFormMapper;

    public StaffController(StaffSearchService staffSearchService, StaffManagementService staffManagementService,
            StaffFormMapper staffFormMapper) {
        this.staffSearchService = staffSearchService;
        this.staffManagementService = staffManagementService;
        this.staffFormMapper = staffFormMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<StaffDto>> findStaff() {
        return ResponseEntity.ok(staffSearchService.fetchActiveStaff());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createStaff(@RequestBody @Valid StaffForm staffForm) {
        short staffId = staffManagementService.createStaff(staffFormMapper.map(staffForm));

        return ResponseEntity.created(URI.create(String.format("/staff/%d", staffId))).build();
    }
}
