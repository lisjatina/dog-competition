package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private DatabaseManager dm;

    public TestController() {
        dm = new DatabaseManager();
    }

    @GetMapping("/test")
    public String testResultAddingForm(Model model){
        model.addAttribute("results", dm.getResults());
        return "test";
    }

    @GetMapping("/results/update/1")
    public String testUpdateResults(Model model){
//
        model.addAttribute("results", dm.getResults());
        return  "test2";
    }
}
