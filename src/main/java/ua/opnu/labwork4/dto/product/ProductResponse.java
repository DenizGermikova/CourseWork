package ua.opnu.labwork4.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Інформація про товар")
public class ProductResponse {

    @Schema(
            description = "Ідентифікатор товару",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Назва товару",
            example = "iPhone 15 Pro"
    )
    private String name;

    @Schema(
            description = "Опис товару",
            example = "Смартфон Apple з пам'яттю 256 ГБ"
    )
    private String description;

    @Schema(
            description = "Ціна товару",
            example = "49999.99"
    )
    private Double price;

    @Schema(
            description = "Кількість товару на складі",
            example = "15"
    )
    private Integer stock;

    public ProductResponse() {
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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