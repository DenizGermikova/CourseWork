package ua.opnu.labwork4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Пошук",
        description = "Повнотекстовий пошук по сутностях системи"
)
@RestController
@RequestMapping("/search")
public class SearchController {

    @Operation(
            summary = "Пошук товарів",
            description = "Виконує пошук товарів за текстовим запитом"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Результати пошуку товарів отримано"
    )
    @GetMapping("/products")
    public String searchProducts(
            @RequestParam
            @Parameter(
                    description = "Текст пошукового запиту",
                    example = "iphone"
            )
            String query
    ) {
        return "Search products: " + query;
    }

    @Operation(
            summary = "Пошук користувачів",
            description = "Виконує пошук користувачів за текстовим запитом"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Результати пошуку користувачів отримано"
    )
    @GetMapping("/users")
    public String searchUsers(
            @RequestParam
            @Parameter(
                    description = "Текст пошукового запиту",
                    example = "ivan"
            )
            String query
    ) {
        return "Search users: " + query;
    }

    @Operation(
            summary = "Пошук замовлень",
            description = "Виконує пошук замовлень за текстовим запитом"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Результати пошуку замовлень отримано"
    )
    @GetMapping("/orders")
    public String searchOrders(
            @RequestParam
            @Parameter(
                    description = "Текст пошукового запиту",
                    example = "order-123"
            )
            String query
    ) {
        return "Search orders: " + query;
    }
}