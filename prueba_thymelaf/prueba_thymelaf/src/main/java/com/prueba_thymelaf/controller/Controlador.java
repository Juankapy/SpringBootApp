package com.prueba_thymelaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Controlador {

    @GetMapping
    public String greeting(
            @RequestParam(required = false,defaultValue = "JuanK") String name, Model model
    ) {
        model.addAttribute("name", name);
        return "saludo";
    }
}
