package net.andresbustamante.myproject.web.controllers;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.api.services.StaffSearchService;

@RestController
@RequestMapping("/staff")
public class StaffController extends AbstractController {

    private final StaffSearchService staffSearchService;

    public StaffController(StaffSearchService staffSearchService) {
        this.staffSearchService = staffSearchService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<StaffDto> findStaff() {
        return staffSearchService.fetchActiveStaff();
    }
}
