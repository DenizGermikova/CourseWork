package ua.opnu.labwork4.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Відповідь з інформацією про користувача")
public class UserResponse {

    @Schema(
            description = "Ідентифікатор користувача",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Ім'я користувача",
            example = "Іван"
    )
    private String firstName;

    @Schema(
            description = "Прізвище користувача",
            example = "Петренко"
    )
    private String lastName;

    @Schema(
            description = "Електронна пошта",
            example = "ivan.petrenko@gmail.com"
    )
    private String email;

    @Schema(
            description = "Номер телефону",
            example = "+380991112233"
    )
    private String phone;

    public UserResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}