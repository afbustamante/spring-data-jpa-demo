package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.api.services.UserSearchService;
import net.andresbustamante.myproject.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {

    private final UserRepository userRepository;

    @Autowired
    public UserSearchServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public User loadUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
