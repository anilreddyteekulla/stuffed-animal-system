package com.stuffed.animal.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@KeySpace("orders")
public class Order {
    @Id
    private Integer id;

    private Date createdDate;

    private BigDecimal totalPrice;

    private List<StuffedAnimal> stuffedAnimals;

    private Integer customerId;

    public Order() {
    }

    public Order(Integer id, Date createdDate, BigDecimal totalPrice, List<StuffedAnimal> stuffedAnimals, Integer customerId) {
        this.id = id;
        this.createdDate = createdDate;
        this.totalPrice = totalPrice;
        this.stuffedAnimals = stuffedAnimals;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<StuffedAnimal> getStuffedAnimals() {
        return stuffedAnimals;
    }

    public void setStuffedAnimals(List<StuffedAnimal> stuffedAnimals) {
        this.stuffedAnimals = stuffedAnimals;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
