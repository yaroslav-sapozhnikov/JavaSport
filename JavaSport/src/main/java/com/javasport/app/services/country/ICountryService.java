package com.javasport.app.services.country;

import com.javasport.app.models.Country;

import java.util.List;

public interface ICountryService {

    void create(Country Country);

    List<Country> readAll();

    Country read(int id);

    boolean update(Country Country, int id);

    boolean delete(int id);
}