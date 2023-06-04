package net.andresbustamante.myproject.batch.processors;

import org.springframework.batch.item.ItemProcessor;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.api.enums.GenderEnum;
import net.andresbustamante.myproject.batch.dto.ImportedUser;
import net.andresbustamante.myproject.core.repositories.UserRepository;

public class ImportUserProcessor implements ItemProcessor<ImportedUser, User> {

    private final UserRepository userRepository;

    public ImportUserProcessor(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User process(final ImportedUser importedUser) throws Exception {
        if (userRepository.existsByEmail(importedUser.getEmail())) {
            return null;
        }

        User user = new User();
        user.setFirstName(importedUser.getFirstName());
        user.setSurname(importedUser.getSurname());
        user.setEmail(importedUser.getEmail());
        user.setGender(GenderEnum.valueOf(importedUser.getGender()));
        user.setActive(true);
        return user;
    }
}
