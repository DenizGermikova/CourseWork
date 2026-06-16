package ua.opnu.labwork4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.dto.ApiErrorResponse;
import ua.opnu.labwork4.model.Category;
import ua.opnu.labwork4.model.Product;
import ua.opnu.labwork4.service.CategoryService;
import ua.opnu.labwork4.service.ProductService;

import java.util.List;

@Tag(
        name = "Товари",
        description = "Операції з товарами магазину"
)
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(
            ProductService productService,
            CategoryService categoryService
    ) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Створити товар",
            description = "Додає новий товар до каталогу"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Товар успішно створено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані товару",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(
                productService.create(product)
        );
    }

    @Operation(
            summary = "Отримати всі товари",
            description = "Повертає список усіх товарів"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список товарів отримано"
    )
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(
                productService.getAll()
        );
    }

    @Operation(
            summary = "Отримати товар",
            description = "Повертає товар за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Товар знайдено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор товару",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                productService.getById(id)
        );
    }

    @Operation(
            summary = "Оновити товар",
            description = "Оновлює інформацію про товар"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Товар оновлено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані товару",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор товару",
                    example = "1"
            )
            Long id,
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(
                productService.update(id, product)
        );
    }

    @Operation(
            summary = "Видалити товар",
            description = "Видаляє товар із каталогу"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Товар видалено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор товару",
                    example = "1"
            )
            Long id
    ) {
        productService.delete(id);

        return ResponseEntity.ok(
                "Product deleted"
        );
    }

    @Operation(
            summary = "Отримати товари категорії",
            description = "Повертає список товарів певної категорії"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Список товарів отримано"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Категорію не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "1"
            )
            Long categoryId
    ) {
        return ResponseEntity.ok(
                productService.getByCategory(categoryId)
        );
    }

    @Operation(
            summary = "Додати категорію до товару",
            description = "Прив'язує категорію до товару"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію додано до товару"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар або категорію не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping("/{id}/categories/{categoryId}")
    public ResponseEntity<Product> addCategory(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор товару",
                    example = "1"
            )
            Long id,

            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "2"
            )
            Long categoryId
    ) {

        Product product = productService.getById(id);
        Category category = categoryService.getById(categoryId);

        product.getCategories().add(category);

        return ResponseEntity.ok(
                productService.update(id, product)
        );
    }

    @Operation(
            summary = "Видалити категорію з товару",
            description = "Видаляє категорію у товару"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію видалено з товару"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар або категорію не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @DeleteMapping("/{id}/categories/{categoryId}")
    public ResponseEntity<Product> removeCategory(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор товару",
                    example = "1"
            )
            Long id,

            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "2"
            )
            Long categoryId
    ) {

        Product product = productService.getById(id);

        product.getCategories().removeIf(
                category -> category.getId().equals(categoryId)
        );

        return ResponseEntity.ok(
                productService.update(id, product)
        );
    }
}