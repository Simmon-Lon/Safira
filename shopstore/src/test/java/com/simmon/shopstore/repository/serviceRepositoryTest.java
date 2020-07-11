package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class serviceRepositoryTest {

    @Autowired
    private serviceRepository serviceRepository;

    @Test
    void findAll(){
        serviceRepository.findAll().forEach(System.out::println);
    }
}