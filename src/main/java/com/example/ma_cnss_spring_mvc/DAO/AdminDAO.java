package com.example.ma_cnss_spring_mvc.DAO;

import com.example.ma_cnss_spring_mvc.Services.JPA;
import com.example.ma_cnss_spring_mvc.entities.AdminEntity;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminDAO implements DAO<AdminEntity> {
    @Override
    public AdminEntity get(long id) {
        AdminEntity admin = JPA.entityManager().find(AdminEntity.class, id);
        return admin;
    }

    @Override
    public List<AdminEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT a from AdminEntity a");
        return query.getResultList();
    }

    @Override
    public void save(AdminEntity admin) {
        JPA.serv(em -> em.persist(admin));
    }

    @Override
    public void update(AdminEntity admin) {

    }

    @Override
    public void delete(long id) throws SQLException {
        AdminEntity admin = JPA.entityManager().find(AdminEntity.class, id);
        JPA.serv(em -> em.remove(admin));
    }
}
