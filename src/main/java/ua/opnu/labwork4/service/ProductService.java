package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.exception.ResourceNotFoundException;
import ua.opnu.labwork4.model.Brand;
import ua.opnu.labwork4.model.Category;
import ua.opnu.labwork4.model.Product;
import ua.opnu.labwork4.repository.BrandRepository;
import ua.opnu.labwork4.repository.CategoryRepository;
import ua.opnu.labwork4.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(
            ProductRepository productRepository,
            BrandRepository brandRepository,
            CategoryRepository categoryRepository
    ) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(Product product) {

        Brand brand = brandRepository.findById(
                product.getBrand().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Brand not found"
                )
        );

        List<Category> categories = product.getCategories()
                .stream()
                .map(category -> categoryRepository.findById(category.getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found"
                                )
                        ))
                .toList();

        product.setBrand(brand);
        product.setCategories(categories);

        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"
                        )
                );
    }

    public Product update(Long id, Product updatedProduct) {

        Product product = getById(id);

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        Brand brand = brandRepository.findById(
                updatedProduct.getBrand().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Brand not found"
                )
        );

        List<Category> categories = updatedProduct.getCategories()
                .stream()
                .map(category -> categoryRepository.findById(category.getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Category not found"
                                )
                        ))
                .toList();

        product.setBrand(brand);
        product.setCategories(categories);

        return productRepository.save(product);
    }

    public void delete(Long id) {

        Product product = getById(id);

        productRepository.delete(product);
    }

    public List<Product> getByCategory(
            Long categoryId
    ) {

        return productRepository
                .findByCategoriesId(categoryId);
    }

    public List<Product> getByBrand(
            Long brandId
    ) {

        return productRepository
                .findByBrandId(brandId);
    }
}