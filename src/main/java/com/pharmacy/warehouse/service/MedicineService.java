package com.pharmacy.warehouse.service;

import com.pharmacy.warehouse.entity.Medicine;
import com.pharmacy.warehouse.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepository repo;

    public MedicineService(MedicineRepository repo) {
        this.repo = repo;
    }

    public List<Medicine> findAll() {
        return repo.findAll();
    }

    public Medicine save(Medicine m) {
        return repo.save(m);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
