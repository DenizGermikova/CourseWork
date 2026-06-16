package ua.opnu.labwork4.dto.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Запит на створення бренду")
public class CreateBrandRequest {

    @Schema(
            description = "Назва бренду",
            example = "Samsung",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Brand name is required")
    private String name;

    @Schema(
            description = "Країна виробника",
            example = "Південна Корея",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Country is required")
    private String country;

    public CreateBrandRequest() {
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}