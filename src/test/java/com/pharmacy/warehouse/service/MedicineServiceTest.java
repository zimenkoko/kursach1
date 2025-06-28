package com.pharmacy.warehouse.service;

import com.pharmacy.warehouse.entity.Medicine;
import com.pharmacy.warehouse.repository.MedicineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MedicineServiceTest {

    @InjectMocks
    private MedicineService service;

    @Mock
    private MedicineRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Medicine> list = List.of(new Medicine());
        when(repository.findAll()).thenReturn(list);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void testSave() {
        Medicine med = new Medicine();
        med.setName("Анальгин");
        med.setManufacturer("Фарм");
        med.setQuantity(100);
        med.setExpirationDate(LocalDate.now().plusYears(1));

        when(repository.save(any(Medicine.class))).thenReturn(med);
        Medicine saved = service.save(med);

        assertEquals("Анальгин", saved.getName());
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);
        service.delete(id);
        verify(repository, times(1)).deleteById(id);
    }
}