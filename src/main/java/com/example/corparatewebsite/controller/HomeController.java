package com.example.corparatewebsite.controller;

import com.example.corparatewebsite.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("services",
                companyService.getServices());

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {

        model.addAttribute("services",
                companyService.getServices());

        return "services";
    }

    @GetMapping("/careers")
    public String careers() {
        return "careers";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}