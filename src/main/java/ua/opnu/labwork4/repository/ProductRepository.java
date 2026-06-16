package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.model.Product;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByCategoriesId(Long categoryId);

    List<Product> findByBrandId(Long brandId);

    List<Product> findByNameContainingIgnoreCase(
            String query
    );
}