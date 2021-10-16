package com.stuffed.animal.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.Date;

@KeySpace("lineitems")
public class LineItem {
    @Id
    private Integer id;
    private int quantity;
    private double price;
    private Date createdDate;
    private Order order;
    private StuffedAnimal stuffedAnimal;

    public LineItem(int quantity, double price, Date createdDate, Order order, StuffedAnimal stuffedAnimal) {
        this.quantity = quantity;
        this.price = price;
        this.createdDate = createdDate;
        this.order = order;
        this.stuffedAnimal = stuffedAnimal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StuffedAnimal getStuffedAnimal() {
        return stuffedAnimal;
    }

    public void setStuffedAnimal(StuffedAnimal stuffedAnimal) {
        this.stuffedAnimal = stuffedAnimal;
    }
}
