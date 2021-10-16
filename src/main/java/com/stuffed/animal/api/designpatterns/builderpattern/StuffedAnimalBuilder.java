package com.stuffed.animal.api.designpatterns.builderpattern;

import com.stuffed.animal.api.models.StuffedAnimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class StuffedAnimalBuilder {
    String name;
    String fabric;
    String color;
    BigDecimal price;
    List<String> stuffings = new ArrayList<>();

    public abstract StuffedAnimalBuilder addFabric(String fabric);

    public abstract StuffedAnimalBuilder addStuffing(String stuffing);

    public abstract StuffedAnimalBuilder addColor(String color);

    public abstract StuffedAnimalBuilder addPrice(BigDecimal integer);

    public StuffedAnimal build() {
        StuffedAnimal stuffedAnimal = new StuffedAnimal();
        stuffedAnimal.setName(this.name);
        stuffedAnimal.setFabric(this.fabric);
        stuffedAnimal.setColor(this.color);
        stuffedAnimal.setStuffings(this.stuffings);
        stuffedAnimal.setPrice(this.price);
        return stuffedAnimal;
    }


}