package ua.opnu.labwork4.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Запит на створення замовлення")
public class CreateOrderRequest {

    @Schema(
            description = "Ідентифікатор користувача",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "User id is required")
    private Long userId;

    @Schema(
            description = "Список ідентифікаторів товарів",
            example = "[1, 2, 3]"
    )
    private List<Long> productIds;

    public CreateOrderRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}