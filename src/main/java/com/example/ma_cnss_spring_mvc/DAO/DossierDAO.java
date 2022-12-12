package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.entities.DossierEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
    public interface DossierDAO extends JpaRepository<DossierEntity,Integer> {
    @Transactional
    @Modifying
    @Query("update DossierEntity d set d.status=?1 where d.id=?2")
    public int UpdateDossierStatus(String status, int id);
}
