package ua.com.alevel.service;

import ua.com.alevel.entity.Owner;

import java.util.List;

public interface OwnerService {

    void create(Owner owner);
    void update(Owner owner);
    void delete(String id);
    Owner findById(String id);
    List<Owner> findAll();
}
