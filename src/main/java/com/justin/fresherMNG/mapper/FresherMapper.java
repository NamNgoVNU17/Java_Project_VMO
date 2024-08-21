package com.justin.fresherMNG.mapper;

import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.entity.Fresher;

import java.util.stream.Collectors;

public class FresherMapper {
    public static FresherDTO toDTO(Fresher fresher) {
        FresherDTO dto = new FresherDTO();
        dto.setId(fresher.getId());
        dto.setName(fresher.getName());
        dto.setEmail(fresher.getEmail());
        dto.setProgrammingLanguage(fresher.getProgrammingLanguage());
        dto.setScore1(fresher.getScore1());
        dto.setScore2(fresher.getScore2());
        dto.setScore3(fresher.getScore3());
        dto.setAverageScore(fresher.getAverageScore());
        dto.setCenterId(fresher.getCenter() != null ? fresher.getCenter().getId() : null);
        dto.setProjectIds(fresher.getProjects().stream()
                .map(project -> project.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Fresher toEntity(FresherDTO dto) {
        Fresher fresher = new Fresher();
        fresher.setId(dto.getId());
        fresher.setName(dto.getName());
        fresher.setEmail(dto.getEmail());
        fresher.setProgrammingLanguage(dto.getProgrammingLanguage());
        fresher.setScore1(dto.getScore1());
        fresher.setScore2(dto.getScore2());
        fresher.setScore3(dto.getScore3());
        // Relationships and average score calculation are typically managed separately
        return fresher;
    }
}
