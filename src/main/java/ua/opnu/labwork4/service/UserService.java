package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.exception.ResourceNotFoundException;
import ua.opnu.labwork4.model.User;
import ua.opnu.labwork4.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        )
                );
    }

    public User update(Long id, User user) {

        User existingUser = getById(id);

        existingUser.setFirstName(
                user.getFirstName()
        );

        existingUser.setLastName(
                user.getLastName()
        );

        existingUser.setEmail(
                user.getEmail()
        );

        existingUser.setPhone(
                user.getPhone()
        );

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {

        User user = getById(id);

        userRepository.delete(user);
    }
}