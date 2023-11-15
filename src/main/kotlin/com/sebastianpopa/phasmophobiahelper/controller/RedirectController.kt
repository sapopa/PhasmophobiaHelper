package com.sebastianpopa.phasmophobiahelper.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class RedirectController {
    @GetMapping("/")
    fun redirectToSwaggerUi() : String{
        return "redirect:/swagger-ui.html"
    }
}