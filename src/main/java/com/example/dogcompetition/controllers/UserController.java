package com.example.dogcompetition.controllers;
import com.example.dogcompetition.data.User;
import com.example.dogcompetition.data.UserRepository;
import com.example.dogcompetition.dto.LoginDto;
import com.example.dogcompetition.services.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserRepository repo;

    public UserController() {
        repo = new UserRepository();
    }

    @GetMapping("/login")
    public String getIndex(Model model) {
        model.addAttribute("error","");
        model.addAttribute("hasError", false);
        return "login";
    }
//HttpSession session
    @PostMapping("/login")
    public String login(LoginDto userData, Model model, HttpServletRequest request) {

        var user = repo.login(userData.getEmail(), userData.getPwd());

        if(user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return "login";
        }

        request.getSession().setAttribute(SessionData.User, user);

        model.addAttribute("user", user);

        return "login";
    }
}
