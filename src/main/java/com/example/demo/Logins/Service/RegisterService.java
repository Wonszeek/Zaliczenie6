package com.example.demo.Logins.Service;


import com.example.demo.Logins.Domain.User;
import com.example.demo.Logins.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository regRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        regRepo.save(user);
    }
    public User loadUserByUsername(String username) {
        return regRepo.findByUsername(username);
    }
    public boolean emailExists(String email) {
        return regRepo.findByEmail(email) != null;
    }
}
