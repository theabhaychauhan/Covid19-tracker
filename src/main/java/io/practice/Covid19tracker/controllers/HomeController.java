package io.practice.Covid19tracker.controllers;


import io.practice.Covid19tracker.services.CovidData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CovidData covidData;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("LocationStats",  covidData.getAllStats());
        return "home";
    }
}
