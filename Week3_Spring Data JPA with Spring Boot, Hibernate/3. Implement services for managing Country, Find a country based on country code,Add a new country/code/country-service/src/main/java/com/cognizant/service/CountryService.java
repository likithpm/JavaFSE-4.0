package com.cognizant.service;
import com.cognizant.entity.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country getCountryByCode(String code) {
        return repository.findById(code).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(String code, Country updated) {
        Country existing = getCountryByCode(code);
        existing.setName(updated.getName());
        return repository.save(existing);
    }

    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    public List<Country> searchByPartialName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}