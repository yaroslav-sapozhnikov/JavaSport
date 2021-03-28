package com.javasport.app.repository;

import com.javasport.app.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>  {
}
