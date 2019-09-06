package com.beerhouse.controller;

import com.beerhouse.model.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeerController {

    @RequestMapping("/")
    public String hello(){
        return "hello project";
    }
}
