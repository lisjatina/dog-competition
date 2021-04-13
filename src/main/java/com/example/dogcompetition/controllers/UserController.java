package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.dto.LoginDto;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private DatabaseManager repo;

//    public UserController() {
//        repo = new DatabaseManager();
//    }

    @GetMapping("/login")
    public String getIndex(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("hasError", false);
        return "login";
    }

    //HttpSession session
    @PostMapping("/login")
    public String login(LoginDto userData, Model model, HttpServletRequest request) {

        var user = repo.login(userData.getEmail(), userData.getPwd());
        if (user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return "login";
        }
//
//        request.getSession().setAttribute(SessionData.User, user);
//
//        model.addAttribute("user", user);
//
        return "login";
        }
    }
