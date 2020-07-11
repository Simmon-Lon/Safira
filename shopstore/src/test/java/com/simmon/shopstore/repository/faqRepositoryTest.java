package com.simmon.shopstore.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class faqRepositoryTest {

    @Autowired
    private faqRepository repository;

    @Test
    void findAll(){
        repository.findAll().forEach(System.out::println);
    }
}