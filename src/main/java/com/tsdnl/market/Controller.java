package com.tsdnl.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regrets")
public class Controller {

    @GetMapping("/hello")
    public String regrets() {
        return "Never stop learning 😍";
    }

}
