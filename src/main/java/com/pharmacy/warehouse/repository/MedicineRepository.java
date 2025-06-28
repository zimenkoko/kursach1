package com.pharmacy.warehouse.repository;

import com.pharmacy.warehouse.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {}
