package com.beerhouse.controller;

import com.beerhouse.controller.dto.BeerDto;
import com.beerhouse.controller.form.BeerForm;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    public List<BeerDto> list(){
        List<Beer> beers = beerRepository.findAll();
        return BeerDto.convert(beers);
    }
    @PostMapping
    public ResponseEntity<BeerDto> register(@RequestBody @Valid BeerForm form, UriComponentsBuilder uriComponentsBuilder){
        Beer beer = form.convert();
        beerRepository.save(beer);

        URI uri = uriComponentsBuilder.path("/beers/{id}").buildAndExpand(beer.getId()).toUri();
        return ResponseEntity.created(uri).body(new BeerDto(beer));
    }

    @GetMapping("/{id}")
    public BeerDto detail(@PathVariable int id){
        Beer beer = beerRepository.getOne(id);
        return new BeerDto(beer);
    }
}
