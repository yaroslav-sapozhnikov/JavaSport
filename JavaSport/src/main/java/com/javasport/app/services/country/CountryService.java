package com.javasport.app.services.country;

import com.javasport.app.models.Country;
import com.javasport.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void create(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country>  readAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country read(int id) {
        return countryRepository.getOne(id);
    }

    @Override
    public boolean update(Country country, int id) {
        if (countryRepository.existsById(id)) {
            country.setId(id);
            countryRepository.save(country);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
