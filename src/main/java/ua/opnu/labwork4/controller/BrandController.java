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
import ua.opnu.labwork4.model.Brand;
import ua.opnu.labwork4.model.Product;
import ua.opnu.labwork4.service.BrandService;
import ua.opnu.labwork4.service.ProductService;

import java.util.List;

@Tag(
        name = "Бренди",
        description = "Управління брендами електроніки"
)
@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final ProductService productService;

    public BrandController(
            BrandService brandService,
            ProductService productService
    ) {
        this.brandService = brandService;
        this.productService = productService;
    }

    @Operation(
            summary = "Створити бренд",
            description = "Створює новий бренд у системі"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Бренд успішно створено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані бренду",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<Brand> create(
            @RequestBody Brand brand
    ) {
        return ResponseEntity.ok(
                brandService.create(brand)
        );
    }

    @Operation(
            summary = "Отримати всі бренди",
            description = "Повертає список усіх брендів"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список брендів отримано"
    )
    @GetMapping
    public ResponseEntity<List<Brand>> getAll() {
        return ResponseEntity.ok(
                brandService.getAll()
        );
    }

    @Operation(
            summary = "Отримати бренд",
            description = "Повертає бренд за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Бренд знайдено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Бренд не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор бренду",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                brandService.getById(id)
        );
    }

    @Operation(
            summary = "Оновити бренд",
            description = "Оновлює інформацію про бренд"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Бренд оновлено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані бренду",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Бренд не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор бренду",
                    example = "1"
            )
            Long id,
            @RequestBody Brand brand
    ) {
        return ResponseEntity.ok(
                brandService.update(id, brand)
        );
    }

    @Operation(
            summary = "Видалити бренд",
            description = "Видаляє бренд із системи"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Бренд видалено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Бренд не знайдено",
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
                    description = "Ідентифікатор бренду",
                    example = "1"
            )
            Long id
    ) {
        brandService.delete(id);

        return ResponseEntity.ok(
                "Brand deleted"
        );
    }

    @Operation(
            summary = "Отримати товари бренду",
            description = "Повертає список товарів, що належать бренду"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Список товарів бренду отримано"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Бренд не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getBrandProducts(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор бренду",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                productService.getByBrand(id)
        );
    }
}