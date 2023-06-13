package com.cybersoft.cozastore_java21.entity;

import com.cybersoft.cozastore_java21.entity.ids.OrderDetailIds;

import javax.persistence.*;

@Entity(name = "order_detail")
public class OrderDetailEntity {

    @EmbeddedId
    OrderDetailIds ids;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false,updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false,updatable = false)
    private OrderEntity order;

    public OrderDetailIds getIds() {
        return ids;
    }

    public void setIds(OrderDetailIds ids) {
        this.ids = ids;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
