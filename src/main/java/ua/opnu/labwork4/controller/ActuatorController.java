package ua.opnu.labwork4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Метрики сервісу",
        description = "Перевірка стану сервісу та отримання технічних метрик"
)
@RestController
public class ActuatorController {

    @Operation(
            summary = "Перевірка стану сервісу",
            description = "Повертає поточний стан працездатності сервісу"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Сервіс працює коректно"
    )
    @GetMapping("/actuator/health")
    public String health() {
        return "OK";
    }

    @Operation(
            summary = "Отримати метрики",
            description = "Повертає список доступних метрик сервісу"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список метрик успішно отримано"
    )
    @GetMapping("/actuator/metrics")
    public String metrics() {
        return "Metrics";
    }

    @Operation(
            summary = "Prometheus метрики",
            description = "Повертає метрики для систем моніторингу Prometheus"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Prometheus метрики успішно отримано"
    )
    @GetMapping("/actuator/prometheus")
    public String prometheus() {
        return "Prometheus metrics";
    }
}