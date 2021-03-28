package com.javasport.app.controllers;


import com.javasport.app.models.Country;
import com.javasport.app.repository.CountryRepository;
import com.javasport.app.services.country.CountryService;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Country country) {
        countryService.create(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Country>> read() {
        final List<Country> countries = countryService.readAll();

        return countries != null &&  !countries.isEmpty()
                ? new ResponseEntity<>(countries, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> read(@PathVariable(name = "id") int id) {
        final Country country = countryService.read(id);

        return country != null
                ? new ResponseEntity<>(country, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Country country) {
        final boolean updated = countryService.update(country, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = countryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
