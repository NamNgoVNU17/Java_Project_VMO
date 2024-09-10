package com.justin.fresherMNG.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String location;

    @OneToMany(mappedBy = "center")
    private List<Fresher> freshers;

    public Center() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Fresher> getFreshers() {
        return freshers;
    }

    public void setFreshers(List<Fresher> freshers) {
        this.freshers = freshers;
    }
}
