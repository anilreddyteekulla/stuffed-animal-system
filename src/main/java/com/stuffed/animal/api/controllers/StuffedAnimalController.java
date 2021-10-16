package com.stuffed.animal.api.controllers;

import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.services.StuffedAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/stuffedanimal")
public class StuffedAnimalController {
    @Autowired
    private StuffedAnimalService stuffedAnimalService;

    @PostMapping("/create")
    public ResponseEntity<StuffedAnimal> createStuffedAnimal(@RequestBody StuffedAnimal stuffedAnimal) {
        return new ResponseEntity<>(stuffedAnimalService.createStuffedAnimal(stuffedAnimal), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StuffedAnimal> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(stuffedAnimalService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<StuffedAnimal> update(@RequestBody StuffedAnimal stuffedAnimal) {
        Objects.requireNonNull(stuffedAnimal.getId(), "Stuffed animal id cannot be null.");
        return new ResponseEntity<>(stuffedAnimalService.updateStuffedAnimal(stuffedAnimal), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(stuffedAnimalService.deleteStuffedAnimal(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StuffedAnimal>> listAll() {
        return new ResponseEntity<>(stuffedAnimalService.listAll(), HttpStatus.OK);
    }
}
