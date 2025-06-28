package com.pharmacy.warehouse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmacy.warehouse.entity.Medicine;
import com.pharmacy.warehouse.service.MedicineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicineController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MedicineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicineService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAll() throws Exception {
        Medicine med = new Medicine();
        med.setName("Цитрамон");
        Mockito.when(service.findAll()).thenReturn(List.of(med));

        mockMvc.perform(get("/api/medicines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Цитрамон"));
    }

    @Test
    void testSave() throws Exception {
        Medicine med = new Medicine();
        med.setName("Нурофен");
        med.setManufacturer("ПромФарм");
        med.setQuantity(50);
        med.setExpirationDate(LocalDate.now().plusYears(1));

        Mockito.when(service.save(any(Medicine.class))).thenReturn(med);

        mockMvc.perform(post("/api/medicines")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(med)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Нурофен"));
    }
}