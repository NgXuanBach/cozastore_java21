package com.cybersoft.cozastore_java21.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_ship")
    private double priceShip;

    @OneToMany(mappedBy = "country")
    private Set<OrderEntity> orders;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceShip() {
        return priceShip;
    }

    public void setPriceShip(double priceShip) {
        this.priceShip = priceShip;
    }
}
