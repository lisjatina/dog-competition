package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Result;
import com.example.dogcompetition.dto.ResultDto;
import com.example.dogcompetition.services.ResultManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;


@Controller
public class ResultController {

   // showing list of entered results (correct)
    @GetMapping("/results")
    public String getResults(Model model){
        var dm = new DatabaseManager();
        model.addAttribute("results", dm.getResults());
          return "results";
    }

   @GetMapping("/results/update")
    public String updateResults(Model model){
        var dm = new DatabaseManager();
        model.addAttribute("results", dm.getResults());
        return "update";
    }

    // with web API


    // without web API
    @PostMapping("/results/{id}")
    public String updateResult(@PathVariable int id, Model model, ResultDto dto){
        var rm = new ResultManager();
        var updated = rm.updateResult(id, dto);
        model.addAttribute("result", updated);
        return "update";
    }

//    //sending result to DB via internet form so far incorrect
//    @PostMapping("/results")
//    public String saveResults(Model model){
//        var dm = new DatabaseManager();
//        model.addAttribute("results", dm.getResults());
//        return "add_results";
//    }


//    @GetMapping("/results/{id}")
//    public String getDynamicResults(@PathVariable int id, Model model){
//        var dm = new DatabaseManager();
//        model.addAttribute("result", dm.getResultById(id));
//        return "test";
//    }




//    @GetMapping("/results")
//    public String getResults(Model model, Integer length, Double speed){
//        Course course = new Course(length, speed);
//        model.addAttribute("course", course);
//        var rm = new ResultManager();
//        var results = rm.getResults(course);
//        model.addAttribute("results", results);
//        return "results";
//    }
}
