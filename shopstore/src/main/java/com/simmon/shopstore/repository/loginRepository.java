package com.simmon.shopstore.repository;

import com.simmon.shopstore.entity.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository {
    public void logon(Login login);
    public Login findByUsername(String lusername);
}
