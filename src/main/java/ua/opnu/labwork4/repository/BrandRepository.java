package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.model.Brand;

public interface BrandRepository
        extends JpaRepository<Brand, Long> {
}