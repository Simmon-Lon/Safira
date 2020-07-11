package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Faq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface faqRepository {
    public List<Faq> findAll();
}
