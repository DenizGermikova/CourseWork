package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.model.User;

public interface UserRepository
        extends JpaRepository<User, Long> {
}