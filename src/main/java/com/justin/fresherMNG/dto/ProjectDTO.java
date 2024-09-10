package com.justin.fresherMNG.dto;


import com.justin.fresherMNG.entity.Project;

import java.time.LocalDate;
import java.util.Set;

public class ProjectDTO {
    private Integer id;
    private String name;
    private String programmingLanguage;
    private Project.ProjectStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer centerId;
    private Set<Integer> fresherIds;

    public Project.ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(Project.ProjectStatus status) {
        this.status = status;
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

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public Set<Integer> getFresherIds() {
        return fresherIds;
    }

    public void setFresherIds(Set<Integer> fresherIds) {
        this.fresherIds = fresherIds;
    }
}
