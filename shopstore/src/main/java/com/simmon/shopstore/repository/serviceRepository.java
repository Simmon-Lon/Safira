package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Service;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface serviceRepository {
    public List<Service> findAll();
}
