package ua.opnu.labwork4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.dto.ApiErrorResponse;
import ua.opnu.labwork4.model.Order;
import ua.opnu.labwork4.service.OrderService;

import java.util.List;

@Tag(
        name = "Замовлення",
        description = "Управління замовленнями користувачів"
)
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @Operation(
            summary = "Створити замовлення",
            description = "Створює нове замовлення"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Замовлення успішно створено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<Order> create(
            @RequestBody Order order
    ) {
        return ResponseEntity.ok(
                orderService.create(order)
        );
    }

    @Operation(
            summary = "Отримати всі замовлення",
            description = "Повертає список усіх замовлень"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список замовлень отримано"
    )
    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(
                orderService.getAll()
        );
    }

    @Operation(
            summary = "Отримати замовлення",
            description = "Повертає замовлення за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Замовлення знайдено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Замовлення не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор замовлення",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                orderService.getById(id)
        );
    }

    @Operation(
            summary = "Оновити замовлення",
            description = "Оновлює інформацію про замовлення"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Замовлення оновлено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Замовлення не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Order> update(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор замовлення",
                    example = "1"
            )
            Long id,
            @RequestBody Order order
    ) {
        return ResponseEntity.ok(
                orderService.update(id, order)
        );
    }

    @Operation(
            summary = "Видалити замовлення",
            description = "Скасовує замовлення"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Замовлення видалено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Замовлення не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор замовлення",
                    example = "1"
            )
            Long id
    ) {
        orderService.delete(id);

        return ResponseEntity.ok(
                "Order deleted"
        );
    }

    @Operation(
            summary = "Активні замовлення",
            description = "Повертає список активних замовлень"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список активних замовлень отримано"
    )
    @GetMapping("/active")
    public ResponseEntity<List<Order>> getActiveOrders() {
        return ResponseEntity.ok(
                orderService.getActiveOrders()
        );
    }
}