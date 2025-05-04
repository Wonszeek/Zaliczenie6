package com.example.demo.Logins.Service;


import com.example.demo.Logins.Domain.Login;
import com.example.demo.Logins.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository regRepo;

    public void save(Login login){
        regRepo.save(login);
    }
    public Login loadUserByUsername(String username) {
        Login login = regRepo.findByUser(username);




        return null;
    }
}
