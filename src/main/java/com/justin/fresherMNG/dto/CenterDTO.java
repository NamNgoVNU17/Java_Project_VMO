package com.justin.fresherMNG.dto;
import java.util.List;

public class CenterDTO {
    private Integer id;
    private String name;
    private List<Integer> fresherIds;
    private List<Integer> projectIds;


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

    public List<Integer> getFresherIds() {
        return fresherIds;
    }

    public void setFresherIds(List<Integer> fresherIds) {
        this.fresherIds = fresherIds;
    }

    public List<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }
}
