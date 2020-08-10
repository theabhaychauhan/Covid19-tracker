package io.practice.Covid19tracker.controllers;


import io.practice.Covid19tracker.models.locationStats;
import io.practice.Covid19tracker.services.CovidData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidData covidData;

    @GetMapping("/")
    public String home(Model model) {
        List<locationStats> allStats = covidData.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("LocationStats",  allStats);
        model.addAttribute("TotalCases", totalCases);
        return "home";
    }
}
