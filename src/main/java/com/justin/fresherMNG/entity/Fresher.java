package com.justin.fresherMNG.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name = "programming_language", nullable = false)
    private String programmingLanguage;

    @Column(name = "score1")
    private Float score1;

    @Column(name = "score2")
    private Float score2;

    @Column(name = "score3")
    private Float score3;

    @Column(name = "average_score")
    private Float averageScore;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @ManyToMany(mappedBy = "freshers")
    private List<Project> projects;


    public Fresher() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Float getScore1() {
        return score1;
    }

    public void setScore1(Float score1) {
        this.score1 = score1;
    }

    public Float getScore2() {
        return score2;
    }

    public void setScore2(Float score2) {
        this.score2 = score2;
    }

    public Float getScore3() {
        return score3;
    }

    public void setScore3(Float score3) {
        this.score3 = score3;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @PrePersist
    @PreUpdate
    private void calculateAverageScore() {
        this.averageScore = (this.score1 + this.score2 + this.score3)/3;
    }
}
