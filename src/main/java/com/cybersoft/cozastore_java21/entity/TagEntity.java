package com.cybersoft.cozastore_java21.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<CategoryTag> categoryTags;

    @OneToMany(mappedBy = "tag")
    private Set<TagBlogEntity> tagBlogs;

    public Set<TagBlogEntity> getTagBlogs() {
        return tagBlogs;
    }

    public void setTagBlogs(Set<TagBlogEntity> tagBlogs) {
        this.tagBlogs = tagBlogs;
    }

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
}
