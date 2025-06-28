package com.pharmacy.warehouse.controller;

import com.pharmacy.warehouse.entity.Medicine;
import com.pharmacy.warehouse.service.MedicineService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medicine> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Medicine> save(@RequestBody Medicine m) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(m));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
