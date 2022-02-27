package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.api.services.UserManagementService;
import net.andresbustamante.myproject.core.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;

    @Autowired
    public UserManagementServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long createUser(User user) {
        user.setActive(true);

        User storedUser = userRepository.save(user);
        return storedUser.getId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user) {
        User storedUser = userRepository.getById(user.getId());
        BeanUtils.copyProperties(user, storedUser);
        userRepository.save(storedUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
}
