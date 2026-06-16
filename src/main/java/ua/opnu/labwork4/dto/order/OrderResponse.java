package ua.opnu.labwork4.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import ua.opnu.labwork4.model.OrderStatus;

import java.time.LocalDateTime;

@Schema(description = "Інформація про замовлення")
public class OrderResponse {

    @Schema(
            description = "Ідентифікатор замовлення",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Дата та час створення замовлення",
            example = "2025-06-10T15:30:00"
    )
    private LocalDateTime orderDate;

    @Schema(
            description = "Загальна вартість замовлення",
            example = "45999.99"
    )
    private Double totalPrice;

    @Schema(
            description = "Статус замовлення",
            example = "ACTIVE"
    )
    private OrderStatus status;

    public OrderResponse() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}