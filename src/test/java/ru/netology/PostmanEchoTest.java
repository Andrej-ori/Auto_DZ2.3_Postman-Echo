package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldSentRequest() {

        // Given - When - Then
        // предусловия
        given()
                .baseUri("https://postman-echo.com") // URI места куда отправляем запрос
                .contentType("text/plain; charset=UTF-8") // кодировка для отправки запроса на кириллице
                .body("Ответ на запрос!") // отправляемые данные
                // Выполняемые действия
                .when()
                .post("/post") // тип запроса
                // Проверки
                .then()
                .statusCode(200) // код предпологаемого ответа
                .body("data", equalTo("Ответ на запрос не прошел!")) // Сама проверка (тот ответ который ждем)
        ;
    }
}