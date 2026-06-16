package ua.opnu.labwork4.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import ua.opnu.labwork4.model.OrderStatus;

@Schema(description = "Запит на зміну статусу замовлення")
public class UpdateOrderStatusRequest {

    @Schema(
            description = "Новий статус замовлення",
            example = "ACTIVE",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Status is required")
    private OrderStatus status;

    public UpdateOrderStatusRequest() {
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}