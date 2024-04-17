package com.example.PSSDD_lBermejo_jlOchoa.Services;

import com.example.PSSDD_lBermejo_jlOchoa.Entities.Supermarket;
import com.example.PSSDD_lBermejo_jlOchoa.Repositories.SupermarketRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupermarketService {

    private SupermarketRepository supermarketRepository;

    @Autowired
    public SupermarketService( SupermarketRepository supermarketRepository) {
        this.supermarketRepository = supermarketRepository;
    }

    public void saveSupermarket ( Supermarket supermarket) {
        supermarketRepository.save(supermarket);
    }

    public Supermarket update( Long id, @Valid UpdateSupermarketForm form ) {
        var supermarket = form.update(id, supermarketRepository);
        return supermarket;
    }

    public void deleteById ( Long id ) {
        supermarketRepository.deleteById(id);
    }

    public List<Supermarket> findAllSupermarket ( ) {
        List<Supermarket> supermarkets = supermarketRepository.findAll();
        return supermarkets;
    }

    public Optional<Supermarket> findById (Long id ) {
        Optional<Supermarket> supermarket = supermarketRepository.findById(id);
        return supermarket;
    }

    public void saveAll ( List<Supermarket> supermarkets) {
        supermarketRepository.saveAll(supermarkets);
    }
}