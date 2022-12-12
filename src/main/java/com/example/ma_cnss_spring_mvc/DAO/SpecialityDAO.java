package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.SpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityDAO extends JpaRepository<SpecialityEntity,Integer> {
    SpecialityEntity findById(int id);
}
