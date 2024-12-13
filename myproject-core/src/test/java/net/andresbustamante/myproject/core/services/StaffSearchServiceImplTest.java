package net.andresbustamante.myproject.core.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.mappers.StaffMapper;

@ExtendWith(MockitoExtension.class)
class StaffSearchServiceImplTest {

    @InjectMocks
    private StaffSearchServiceImpl staffSearchService;

    @Mock
    private StaffDao staffDao;

    @Mock
    private StaffMapper staffMapper;

    @Test
    void testFetchActiveStaff() {
        when(staffDao.findAllActiveStaff()).thenReturn(new ArrayList<>());
        when(staffMapper.map(any(Collection.class))).thenReturn(new ArrayList<>());

        var result = staffSearchService.fetchActiveStaff();

        assertNotNull(result);

        verify(staffDao).findAllActiveStaff();
        verify(staffMapper).map(any(Collection.class));
    }
}