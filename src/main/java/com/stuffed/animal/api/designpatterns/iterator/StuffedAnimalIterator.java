package com.stuffed.animal.api.designpatterns.iterator;

import com.stuffed.animal.api.models.StuffedAnimal;

import java.util.List;

public class StuffedAnimalIterator implements IIterator {
    List<StuffedAnimal> list;
    int index = 0;

    public StuffedAnimalIterator(List<StuffedAnimal> list) {
        this.list = list;
    }

    @Override
    public StuffedAnimal next() {
        StuffedAnimal stuffedAnimal = list.get(index);
        index = index + 1;
        return stuffedAnimal;
    }

    @Override
    public boolean hasNext() {
        return index < list.size() && list.get(index) != null;
    }
}

