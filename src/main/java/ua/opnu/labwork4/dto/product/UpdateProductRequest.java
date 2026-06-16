package ua.opnu.labwork4.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Запит на оновлення товару")
public class UpdateProductRequest {

    @Schema(
            description = "Назва товару",
            example = "Samsung Galaxy S25",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Product name is required")
    private String name;

    @Schema(
            description = "Опис товару",
            example = "Флагманський смартфон Samsung"
    )
    private String description;

    @Schema(
            description = "Ціна товару",
            example = "42999.99",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Positive(message = "Price must be positive")
    private Double price;

    @Schema(
            description = "Кількість товару на складі",
            example = "20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;

    public UpdateProductRequest() {
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
}