package ua.com.alevel.dao;

import ua.com.alevel.entity.Owner;

import java.util.List;

public interface OwnerDao {

    void create(Owner owner);
    void update(Owner owner);
    void delete(String id);
    Owner findById(String id);
    boolean existByEmail(String email);
    List<Owner> findAll();
}
