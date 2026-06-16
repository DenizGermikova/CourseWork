package ua.opnu.labwork4.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Інформація про категорію товару")
public class CategoryResponse {

    @Schema(
            description = "Ідентифікатор категорії",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Назва категорії",
            example = "Смартфони"
    )
    private String name;

    @Schema(
            description = "Опис категорії",
            example = "Мобільні телефони та смартфони"
    )
    private String description;

    public CategoryResponse() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}