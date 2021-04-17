package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.User;
import com.example.dogcompetition.services.SessionData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;

@Controller
public class ResultController {

    private DatabaseManager dm;

    public ResultController() {
        dm = new DatabaseManager();
    }

   // showing list of entered results in descending order (correct)
    @GetMapping("/results")
    public String getResults(Model model){
//        model.addAttribute("ag", dm.getSortedResults());
        model.addAttribute("agility0", dm.getSortedResultsForA0());
        model.addAttribute("agility1", dm.getSortedResultsForA1());
        model.addAttribute("agility2", dm.getSortedResultsForA2());
        model.addAttribute("agility3", dm.getSortedResultsForA3());
        return "results";
    }

   @GetMapping("/results/update")
    public ModelAndView updateResults(Model model, HttpSession session) throws AccessDeniedException {
      var user = (User) session.getAttribute(SessionData.User);
      if (user == null) {
          return new ModelAndView( "redirect:/login");
      }
       model.addAttribute("user", user);
       model.addAttribute("results", dm.getResults());
       model.addAttribute("confirmDelete", 0);

        return new ModelAndView("update");
    }

    @GetMapping("/confirm/{id}")
    public String confirmDelete(@PathVariable int id, Model model){
//        var user = (User) session.getAttribute(SessionData.User);
//        model.addAttribute("user", user);

        model.addAttribute("results", dm.getResults());
        model.addAttribute("confirmDelete", id);

        return  "update";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem(@PathVariable int id, Model model){
//        var user = (User) session.getAttribute(SessionData.User);
//        model.addAttribute("user", user);

        var dataToDelete = dm.getResultById(id);

        if (dataToDelete != null){
            dm.delete(dataToDelete);
        }

        return new ModelAndView("redirect:/results/update");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    class ForbiddenException extends RuntimeException {}
}
