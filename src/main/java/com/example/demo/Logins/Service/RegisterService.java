package com.example.demo.Logins.Service;


import com.example.demo.Logins.Domain.User;
import com.example.demo.Logins.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository regRepo;

    public void save(User user){
        regRepo.save(user);
    }
    public User loadUserByUsername(String username) {
        return regRepo.findByUsername(username);
    }
    public boolean emailExists(String email) {
        return regRepo.findByEmail(email) != null;
    }
}
