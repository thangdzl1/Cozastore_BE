package com.cybersoft.cozastore.entity;

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
    private Set<CategoryTagEntity> categoryTagEntities;

    @OneToMany(mappedBy = "tag")
    private Set<TagBlogEntity> tagBlogs;

    public Set<TagBlogEntity> getTagBlogs() {
        return tagBlogs;
    }

    public void setTagBlogs(Set<TagBlogEntity> tagBlogs) {
        this.tagBlogs = tagBlogs;
    }

    public Set<CategoryTagEntity> getCategoryTags() {
        return categoryTagEntities;
    }

    public void setCategoryTags(Set<CategoryTagEntity> categoryTagEntities) {
        this.categoryTagEntities = categoryTagEntities;
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
