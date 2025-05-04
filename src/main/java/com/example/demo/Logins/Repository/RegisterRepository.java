package com.example.demo.Logins.Repository;

import com.example.demo.Logins.Domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegisterRepository extends JpaRepository<Login, Long> {
    public Login findByUser(String username);

}
