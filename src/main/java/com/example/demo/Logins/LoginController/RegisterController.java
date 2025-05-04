package com.example.demo.Logins.LoginController;

//import com.example.demo.Logins.Register.Register;
//import ch.qos.logback.core.model.Model;
import com.example.demo.Logins.Domain.Login;
import com.example.demo.Logins.Register.Register;
import com.example.demo.Logins.Service.LoginService;
import com.example.demo.Logins.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService RegisterService;

    @GetMapping("/register")
    public String register(Model model) {
        Login register = new Login();
        model.addAttribute(register);
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model,
                      @ModelAttribute Login register,
                           BindingResult result) {
        Login newUser = new Login();
        newUser.setUsername(register.getUsername());
        newUser.setPassword(register.getPassword());

        RegisterService.save(newUser);
        return "register";
    }



}
