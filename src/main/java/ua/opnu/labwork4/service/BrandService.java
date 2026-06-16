package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.exception.ResourceNotFoundException;
import ua.opnu.labwork4.model.Brand;
import ua.opnu.labwork4.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(
            BrandRepository brandRepository
    ) {
        this.brandRepository = brandRepository;
    }

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand getById(Long id) {

        return brandRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Brand not found"
                        )
                );
    }

    public Brand update(Long id, Brand brand) {

        Brand existingBrand = getById(id);

        existingBrand.setName(
                brand.getName()
        );

        existingBrand.setCountry(
                brand.getCountry()
        );

        return brandRepository.save(
                existingBrand
        );
    }

    public void delete(Long id) {

        Brand brand = getById(id);

        brandRepository.delete(brand);
    }
}