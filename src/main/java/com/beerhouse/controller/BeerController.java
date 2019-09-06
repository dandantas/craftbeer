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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/beers")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    @Transactional
    public List<BeerDto> list(){
        List<Beer> beers = beerRepository.findAll();
        return BeerDto.convert(beers);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<BeerDto> register(@RequestBody @Valid BeerForm form, UriComponentsBuilder uriComponentsBuilder){
        Beer beer = form.convert();
        beerRepository.save(beer);

        URI uri = uriComponentsBuilder.path("/beers/{id}").buildAndExpand(beer.getId()).toUri();
        return ResponseEntity.created(uri).body(new BeerDto(beer));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<BeerDto> detail(@PathVariable int id){
        Optional<Beer> beer = beerRepository.findById(id);
        if(beer.isPresent())
            return ResponseEntity.ok(new BeerDto(beer.get()));
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<BeerDto> update(@PathVariable int id, @RequestBody @Valid BeerForm form){
        Optional<Beer> optional = beerRepository.findById(id);
        if(optional.isPresent()){
            Beer beer = form.update(id, beerRepository);
            return ResponseEntity.ok(new BeerDto(beer));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<BeerDto> delete(@PathVariable int id){
        Optional<Beer> optional = beerRepository.findById(id);
        if(optional.isPresent()){
            beerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
