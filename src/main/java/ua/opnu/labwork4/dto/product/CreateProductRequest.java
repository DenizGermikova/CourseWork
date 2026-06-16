package ua.opnu.labwork4.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Запит на створення товару")
public class CreateProductRequest {

    @Schema(
            description = "Назва товару",
            example = "iPhone 15 Pro",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Product name is required")
    private String name;

    @Schema(
            description = "Опис товару",
            example = "Смартфон Apple з пам'яттю 256 ГБ"
    )
    private String description;

    @Schema(
            description = "Ціна товару",
            example = "49999.99",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Positive(message = "Price must be positive")
    private Double price;

    @Schema(
            description = "Кількість товару на складі",
            example = "15",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;

    @Schema(
            description = "Ідентифікатор бренду",
            example = "1"
    )
    private Long brandId;

    public CreateProductRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}