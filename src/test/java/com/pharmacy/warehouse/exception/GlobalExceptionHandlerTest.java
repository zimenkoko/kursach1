package com.pharmacy.warehouse.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleGenericException() {
        Exception ex = new RuntimeException("Ошибка!");
        ResponseEntity<String> response = handler.handleException(ex);

        assertEquals(500, response.getStatusCode().value());
        assertTrue(response.getBody().contains("Ошибка!"));
    }
}
