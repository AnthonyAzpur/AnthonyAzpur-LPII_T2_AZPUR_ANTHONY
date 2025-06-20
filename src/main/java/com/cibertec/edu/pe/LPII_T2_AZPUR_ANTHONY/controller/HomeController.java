package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "index"; 
    }
}
