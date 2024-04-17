package com.example.PSSDD_lBermejo_jlOchoa.Services;

import com.example.PSSDD_lBermejo_jlOchoa.Entities.Aisle;
import com.example.PSSDD_lBermejo_jlOchoa.Repositories.AisleRepository;
import com.example.PSSDD_lBermejo_jlOchoa.Repositories.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AisleService {

    private AisleRepository aisleRepository;

    @Autowired
    public AisleService( AisleRepository aisleRepository) {
        this.aisleRepository = aisleRepository;
    }

    public void saveAisle ( Aisle aisle) {
        aisleRepository.save(aisle);
    }

    public Aisle update( Long id, @Valid UpdateAisleForm form ) {
        var aisle = form.update(id, aisleRepository);
        return aisle
    }

    public void deleteById ( Long id ) {
        aisleRepository.deleteById(id);
    }

    public List<Aisle> findAllAisles ( ) {
        List<Aisle> aisles = aisleRepository.findAll();
        return aisles;
    }

    public Optional<Aisle> findById (Long id ) {
        Optional<Aisle> aisle = aisleRepository.findById(id);
        return aisle;
    }

    public void saveAll ( List<Aisle> aisles) {
        aisleRepository.saveAll(aisles);
    }

    public AisleService(AisleRepository aisleRepository, FoodRepository foodRepository){
        this.foodRepository = foodRepository;
        this.aisleRepository = aisleRepository;
    }
    public void addFoodToAisle (Long aisleId, Long foodId) throws NotFoundException{
        //Complete after mapping
        Aisle aisle = aisleRepository.findyId(aisleId)
                .orElseThrow(() -> new NotFoundException("Aisle not found"));
        Food food = foodRepository.findById(foodId)
                .orElseThrow( () -> new NotFoundException("Food not found"));
    }

}