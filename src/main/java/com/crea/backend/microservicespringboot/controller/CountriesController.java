package com.crea.backend.microservicespringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CountriesController {

    @GetMapping(value = "/countries")
    public List<Object> getCountries () {
        String url = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();

        Object[] countries = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(countries);
    }

    @GetMapping("/country/code/{countryCode}")
    public Object getCountryByCode(@PathVariable String countryCode) {
        String url = "https://restcountries.com/v3.1/" + "alpha/" + countryCode;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/country/name/{countryName}")
    public Object getCountryByName(@PathVariable String countryName) {
        String url = "https://restcountries.com/v3.1/" + "name/" + countryName;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Object.class);
    }
    
}
