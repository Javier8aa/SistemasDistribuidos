package com.example.PSSDD_lBermejo_jlOchoa.Services;

import com.example.PSSDD_lBermejo_jlOchoa.Entities.Food;
import com.example.PSSDD_lBermejo_jlOchoa.Repositories.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService( FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void saveFood ( Food food) {
        foodRepository.save(food);
    }

    public Food update( Long id, @Valid UpdateFoodForm form ) {
        var food = form.update(id, foodRepository);
        return food;
    }

    public void deleteById ( Long id ) {
        foodRepository.deleteById(id);
    }

    public List<Food> findAllFoods ( ) {
        List<Food> foods = foodRepository.findAll();
        return foods;
    }

    public Optional<Food> findById ( Long id ) {
        Optional<Food> food = foodRepository.findById(id);
        return food;
    }

    public void saveAll ( List<Food> foods) {
        foodRepository.saveAll(foods);
    }
}
