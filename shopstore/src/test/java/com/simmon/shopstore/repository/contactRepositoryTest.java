package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class contactRepositoryTest {

    @Autowired
    private contactRepository contactRepository;

    @Test
    void save(){
        /*Contact contact=new Contact();
        contact.setCname("小明");
        contact.setCemail("1149653250@qq.com");
        contact.setCpinformation("撒谎大会啥的");
        contact.setCyinformation("还行");
        contactRepository.save(contact);*/
    }
}