package com.example.PSSDD_lBermejo_jlOchoa.Services;

import com.example.PSSDD_lBermejo_jlOchoa.Repositories.AisleRepository;
import com.example.PSSDD_lBermejo_jlOchoa.Repositories.FoodRepository;

public class AisleService (AisleRepository aisleRepository, FoodRepository foodRepository){
    this.foodRepository = foodRepository;
    this.aisleRepository = aisleRepository;
}
