package com.example.demo.Logins.Service;

import com.example.demo.Logins.Domain.User;
import com.example.demo.Logins.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public boolean login(String email, String password, HttpSession session) {
        User user = repo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}





