package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Login;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class loginRepositoryTest {

    @Autowired
    private loginRepository loginRepository;


    @Test
    void findByUsername(){
        System.out.println(loginRepository.findByUsername("simmon"));
    }
}