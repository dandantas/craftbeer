package com.beerhouse.repository;

import com.beerhouse.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {


    Optional<Beer> findById(int id);

    void deleteById(int id);
}
