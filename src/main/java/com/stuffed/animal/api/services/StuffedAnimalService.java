package com.stuffed.animal.api.services;

import com.stuffed.animal.api.models.StuffedAnimal;

import java.util.List;

public interface StuffedAnimalService {
    StuffedAnimal createStuffedAnimal(StuffedAnimal stuffedAnimal);

    StuffedAnimal updateStuffedAnimal(StuffedAnimal stuffedAnimal);

    boolean deleteStuffedAnimal(Integer id);

    StuffedAnimal findById(Integer id);

    List<StuffedAnimal> findByIds(List<Integer> ids);

    List<StuffedAnimal> listAll();
}
