package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDAO extends JpaRepository<MedicationEntity,Integer> {
    MedicationEntity findById(int id);
}
