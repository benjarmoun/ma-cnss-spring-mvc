package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.AgentEntity;
import com.example.ma_cnss_spring_mvc.entities.DossierEntity;
import com.example.ma_cnss_spring_mvc.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientDAO extends JpaRepository<PatientEntity,Integer> {
    PatientEntity getByMat(int mat);
    PatientEntity findByEmail(String email);

}
