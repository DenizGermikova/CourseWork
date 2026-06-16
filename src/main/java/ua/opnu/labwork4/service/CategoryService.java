package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.exception.ResourceNotFoundException;
import ua.opnu.labwork4.model.Category;
import ua.opnu.labwork4.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(
            CategoryRepository categoryRepository
    ) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"
                        )
                );
    }

    public void delete(Long id) {

        Category category = getById(id);

        categoryRepository.delete(category);
    }
    public Category update(Long id, Category updatedCategory) {

        Category category = getById(id);

        category.setName(updatedCategory.getName());
        category.setDescription(updatedCategory.getDescription());

        return categoryRepository.save(category);
    }
}