package com.world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.world.model.Country;

@Controller
public class SampleController {

    @RequestMapping("/")
    public String index(Model model) {

        return "hello";
    }

    @RequestMapping("/save")
    public String save(Country country) {
  
        return "redirect:/";
    }
}