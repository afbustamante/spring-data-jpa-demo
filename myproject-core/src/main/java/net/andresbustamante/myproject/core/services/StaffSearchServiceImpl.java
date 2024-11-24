package net.andresbustamante.myproject.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.api.services.StaffSearchService;
import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.entities.Staff;
import net.andresbustamante.myproject.core.mappers.StaffMapper;

@Service
@Transactional(readOnly = true)
public class StaffSearchServiceImpl implements StaffSearchService {

    private final StaffDao staffDao;
    private final StaffMapper staffMapper;

    public StaffSearchServiceImpl(StaffDao staffDao, StaffMapper staffMapper) {
        this.staffDao = staffDao;
        this.staffMapper = staffMapper;
    }

    @Override
    public Collection<StaffDto> fetchActiveStaff() {
        List<Staff> activeStaff = staffDao.findAllByActiveTrue();
        return staffMapper.map(activeStaff);
    }
}
