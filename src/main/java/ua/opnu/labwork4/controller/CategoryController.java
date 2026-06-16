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
import ua.opnu.labwork4.service.CategoryService;

import java.util.List;

@Tag(
        name = "Категорії",
        description = "Управління категоріями товарів"
)
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Створити категорію",
            description = "Створює нову категорію товарів"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію успішно створено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані категорії",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<Category> create(
            @RequestBody Category category
    ) {
        return ResponseEntity.ok(
                categoryService.create(category)
        );
    }

    @Operation(
            summary = "Отримати всі категорії",
            description = "Повертає список усіх категорій"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список категорій отримано"
    )
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(
                categoryService.getAll()
        );
    }

    @Operation(
            summary = "Отримати категорію",
            description = "Повертає категорію за її ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію знайдено"
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
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                categoryService.getById(id)
        );
    }

    @Operation(
            summary = "Оновити категорію",
            description = "Оновлює інформацію про категорію"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію оновлено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані категорії",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
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
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "1"
            )
            Long id,

            @RequestBody Category category
    ) {
        return ResponseEntity.ok(
                categoryService.update(id, category)
        );
    }

    @Operation(
            summary = "Видалити категорію",
            description = "Видаляє категорію із системи"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Категорію видалено"
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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор категорії",
                    example = "1"
            )
            Long id
    ) {
        categoryService.delete(id);

        return ResponseEntity.ok(
                "Category deleted"
        );
    }
}