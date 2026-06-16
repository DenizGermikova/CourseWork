package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Структура відповіді при виникненні помилки")
public class ApiErrorResponse {

    @Schema(
            description = "Текст помилки",
            example = "Користувача не знайдено"
    )
    private String message;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}