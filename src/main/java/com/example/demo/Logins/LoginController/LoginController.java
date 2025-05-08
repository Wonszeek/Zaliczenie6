package com.example.demo.Logins.LoginController;

import com.example.demo.Logins.Domain.User;
import com.example.demo.Logins.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private LoginService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }


    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session) {

        boolean success = userService.login(email, password, session);

        if (success) {
            return new ModelAndView("redirect:/index2");
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("errorMessage", "Niepoprawne dane logowania");
            mav.addObject("user", new User());
            return mav;
        }
    }



    @RequestMapping (value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpSession session) {
        userService.logout(session);
        return "login";
    }
}
