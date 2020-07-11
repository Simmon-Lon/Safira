package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Contact;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository {
    public void save(Contact contact);
}
