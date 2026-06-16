package ua.opnu.labwork4.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shopOpenApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Система управління інтернет-магазином електроніки")
                                .version("1.0.0")
                                .description("""
                                        REST API для управління товарами,
                                        категоріями, брендами, користувачами
                                        та замовленнями.

                                        Система реалізована з використанням
                                        Spring Boot, Spring Data JPA та PostgreSQL.
                                        """)
                                .contact(
                                        new Contact()
                                                .name("Кафедра інформаційних систем")
                                                .email("student@opnu.ua")
                                )
                );
    }
}