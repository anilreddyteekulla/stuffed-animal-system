package com.stuffed.animal.api.designpatterns.builderpattern;

import java.math.BigDecimal;

public class BunnyStuffedAnimalBuilder extends StuffedAnimalBuilder {
    public BunnyStuffedAnimalBuilder() {
        this.name = "Bunny";
    }

    public StuffedAnimalBuilder addFabric(String fabric) {
        this.fabric = fabric;
        return this;
    }

    public StuffedAnimalBuilder addStuffing(String stuffing) {
        this.stuffings.add(stuffing);
        return this;
    }

    public StuffedAnimalBuilder addColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public StuffedAnimalBuilder addPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}