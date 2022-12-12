package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.RadioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadioDAO extends JpaRepository<RadioEntity,Integer> {
    RadioEntity findById(int id);
}
