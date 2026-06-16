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
import ua.opnu.labwork4.model.User;
import ua.opnu.labwork4.service.OrderService;
import ua.opnu.labwork4.service.UserService;

import java.util.List;

@Tag(
        name = "Користувачі",
        description = "Управління користувачами системи онлайн-магазину"
)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    public UserController(
            UserService userService,
            OrderService orderService
    ) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @Operation(
            summary = "Створити користувача",
            description = "Створює нового користувача системи"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Користувача успішно створено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані користувача",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<User> create(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(
                userService.create(user)
        );
    }

    @Operation(
            summary = "Отримати всіх користувачів",
            description = "Повертає список усіх користувачів"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список користувачів отримано"
    )
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(
                userService.getAll()
        );
    }

    @Operation(
            summary = "Отримати користувача",
            description = "Повертає користувача за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Користувача знайдено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Користувача не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор користувача",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                userService.getById(id)
        );
    }

    @Operation(
            summary = "Оновити користувача",
            description = "Оновлює дані користувача"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Користувача оновлено"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некоректні дані користувача",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Користувача не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор користувача",
                    example = "1"
            )
            Long id,
            @RequestBody User user
    ) {
        return ResponseEntity.ok(
                userService.update(id, user)
        );
    }

    @Operation(
            summary = "Видалити користувача",
            description = "Видаляє користувача із системи"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Користувача видалено"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Користувача не знайдено",
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
                    description = "Ідентифікатор користувача",
                    example = "1"
            )
            Long id
    ) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }

    @Operation(
            summary = "Отримати замовлення користувача",
            description = "Повертає історію замовлень користувача"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Список замовлень отримано"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Користувача не знайдено",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ApiErrorResponse.class
                            )
                    )
            )
    })
    @GetMapping("/{id}/orders")
    public ResponseEntity<List<Order>> getUserOrders(
            @PathVariable
            @Parameter(
                    description = "Ідентифікатор користувача",
                    example = "1"
            )
            Long id
    ) {
        return ResponseEntity.ok(
                orderService.getByUserId(id)
        );
    }
}