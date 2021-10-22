package com.stuffed.animal.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.math.BigDecimal;
import java.util.List;

@KeySpace("stuffedanimals")
public class StuffedAnimal {
    @Id
    private Integer id;
    private String name;
    private String fabric;
    private List<String> stuffings;
    private String color;
    private BigDecimal price;

    public StuffedAnimal() {
    }

    public StuffedAnimal(String name, String fabric, List<String> stuffings, String color, BigDecimal price) {
        this.name = name;
        this.fabric = fabric;
        this.stuffings = stuffings;
        this.color = color;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public List<String> getStuffings() {
        return stuffings;
    }

    public void setStuffings(List<String> stuffings) {
        this.stuffings = stuffings;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
