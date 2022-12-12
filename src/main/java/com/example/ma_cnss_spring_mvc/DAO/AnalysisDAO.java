package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.AnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisDAO extends JpaRepository<AnalysisEntity,Integer> {
    AnalysisEntity findById(int id);
}
