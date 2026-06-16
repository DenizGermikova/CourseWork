package ua.opnu.labwork4.dto.brand;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Інформація про бренд")
public class BrandResponse {

    @Schema(
            description = "Ідентифікатор бренду",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Назва бренду",
            example = "Samsung"
    )
    private String name;

    @Schema(
            description = "Країна виробника",
            example = "Південна Корея"
    )
    private String country;

    public BrandResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}