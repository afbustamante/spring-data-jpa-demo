package net.andresbustamante.myproject.core.services;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.entities.Staff;

@Service
@Slf4j
public class StaffAuthenticationServiceImpl implements UserDetailsService {

    private final StaffDao staffDao;

    public StaffAuthenticationServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Staff staff = staffDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                "Username not found"));

        if (!staff.isActive()) {
            log.warn("Attempt of authentication for a deactivated user: {}", username);
            throw new UsernameNotFoundException("Username not found");
        }

        return new User(staff.getUsername(), staff.getPassword(), Collections.emptyList());
    }
}
