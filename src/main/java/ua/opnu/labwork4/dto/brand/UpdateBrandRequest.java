package ua.opnu.labwork4.dto.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Запит на оновлення бренду")
public class UpdateBrandRequest {

    @Schema(
            description = "Назва бренду",
            example = "Apple",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Brand name is required")
    private String name;

    @Schema(
            description = "Країна виробника",
            example = "США",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Country is required")
    private String country;

    public UpdateBrandRequest() {
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