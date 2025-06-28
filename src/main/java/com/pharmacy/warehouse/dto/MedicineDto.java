package com.pharmacy.warehouse.dto;

import java.time.LocalDate;

public record MedicineDto(Long id, String name, String manufacturer, int quantity, LocalDate expirationDate) {}
