package com.justin.fresherMNG.dto;


import java.util.Date;
import java.util.List;

public class ProjectDTO {
    private Integer id;
    private String code;
    private String name;
    private Integer centerId;
    private String manager;
    private Date startDate;
    private Date endDate;
    private String language;
    private String status;
    private List<Integer> fresherIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getFresherIds() {
        return fresherIds;
    }

    public void setFresherIds(List<Integer> fresherIds) {
        this.fresherIds = fresherIds;
    }
}
