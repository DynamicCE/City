package com.erkan.City.controller;

import com.erkan.City.model.City;
import com.erkan.City.result.Result;
import com.erkan.City.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public
class CityController {
    private
    CityService cityService;

    public
    CityController ( CityService cityService ) {
        this.cityService = cityService;
    }

    @GetMapping("/get")
    public
    ResponseEntity<Result<List<City>>> getCities(){
        Result<List<City>> result = cityService.getCities ();
        return new ResponseEntity(result, HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<City>> getCityById( @PathVariable Long id ){
        Result<City> result = cityService.getCityById (id);
        return new ResponseEntity(result, HttpStatus.OK );
    }
}
