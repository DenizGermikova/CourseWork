package ua.opnu.labwork4.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Запит на створення категорії")
public class CreateCategoryRequest {

    @Schema(
            description = "Назва категорії",
            example = "Ноутбуки",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Category name is required")
    private String name;

    @Schema(
            description = "Опис категорії",
            example = "Портативні комп'ютери різних виробників"
    )
    private String description;

    public CreateCategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}