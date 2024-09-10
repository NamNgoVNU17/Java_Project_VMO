package com.justin.fresherMNG.dto;

public class FresherDTO {
    private Integer id;
    private String name;
    private String email;
    private String programmingLanguage;
    private Float score1;
    private Float score2;
    private Float score3;
    private Float avgScore;
    private CenterDTO centerDTO;

    public Float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }

    public Float getScore3() {
        return score3;
    }

    public void setScore3(Float score3) {
        this.score3 = score3;
    }

    public Float getScore2() {
        return score2;
    }

    public void setScore2(Float score2) {
        this.score2 = score2;
    }

    public Float getScore1() {
        return score1;
    }

    public void setScore1(Float score1) {
        this.score1 = score1;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Float calAvgScore() {
        return (score3+score2+score1)/3;
    }

    public CenterDTO getCenterDTO() {
        return centerDTO;
    }

    public void setCenterDTO(CenterDTO centerDTO) {
        this.centerDTO = centerDTO;
    }
}
