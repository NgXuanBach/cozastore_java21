package com.cybersoft.cozastore_java21.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<CategoryTag> categoryTags;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products;

    public Set<CategoryTag> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(Set<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
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

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
