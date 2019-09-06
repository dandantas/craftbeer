package com.beerhouse.controller;

import com.beerhouse.controller.dto.BeerDto;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @RequestMapping("/")
    public String hello(){
        return "hello project";
    }


    @RequestMapping("/beers")
    public List<BeerDto> list(){
        List<Beer> beers = beerRepository.findAll();
        return BeerDto.convert(beers);
    }
}
