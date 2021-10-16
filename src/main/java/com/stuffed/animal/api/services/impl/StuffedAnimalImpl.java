package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.exceptions.NoStuffedAnimalFoundException;
import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.repositories.StuffedAnimalRepository;
import com.stuffed.animal.api.services.StuffedAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StuffedAnimalImpl implements StuffedAnimalService {
    @Autowired
    private StuffedAnimalRepository stuffedAnimalRepository;

    @Override
    public StuffedAnimal createStuffedAnimal(StuffedAnimal stuffedAnimal) {
        return stuffedAnimalRepository.save(stuffedAnimal);
    }

    @Override
    public StuffedAnimal updateStuffedAnimal(StuffedAnimal stuffedAnimal) {
        Optional<StuffedAnimal> stuffedAnimalOptional = stuffedAnimalRepository.findById(stuffedAnimal.getId());
        if (stuffedAnimalOptional.isPresent()) {
            StuffedAnimal existingStuffedAnimal = stuffedAnimalOptional.get();
            existingStuffedAnimal.setName(stuffedAnimal.getName());
            existingStuffedAnimal.setFabric(stuffedAnimal.getFabric());
            existingStuffedAnimal.setStuffings(stuffedAnimal.getStuffings());
            existingStuffedAnimal.setColor(stuffedAnimal.getColor());
            existingStuffedAnimal.setPrice(stuffedAnimal.getPrice());
            return stuffedAnimalRepository.save(existingStuffedAnimal);
        } else {
            throw new NoStuffedAnimalFoundException("No stuffed animal exists with id " + stuffedAnimal.getId());
        }
    }

    @Override
    public boolean deleteStuffedAnimal(Integer stuffedAnimalId) {
        stuffedAnimalRepository.deleteById(stuffedAnimalId);
        return true;
    }

    @Override
    public StuffedAnimal findById(Integer id) {
        Optional<StuffedAnimal> stuffedAnimalOptional = stuffedAnimalRepository.findById(id);
        if (stuffedAnimalOptional.isPresent()) {
            return stuffedAnimalOptional.get();
        } else {
            throw new NoStuffedAnimalFoundException("No stuffed animal found with id " + id);
        }
    }

    @Override
    public List<StuffedAnimal> findByIds(List<Integer> ids) {
        return ids.stream()
                .map(stuffedAnimalRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

    @Override
    public List<StuffedAnimal> listAll() {
        List<StuffedAnimal> animals = new ArrayList<>();
        stuffedAnimalRepository.findAll().forEach(animals::add);
        return animals;
    }
}
