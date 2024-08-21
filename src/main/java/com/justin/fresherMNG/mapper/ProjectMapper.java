package com.justin.fresherMNG.mapper;

import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Project;

import java.util.stream.Collectors;

public class ProjectMapper {
    public static ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setCode(project.getCode());
        dto.setName(project.getName());
        dto.setCenterId(project.getCenter() != null ? project.getCenter().getId() : null);
        dto.setManager(project.getManager());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setLanguage(project.getLanguage());
        dto.setStatus(project.getStatus().name());
        dto.setFresherIds(project.getFreshers().stream()
                .map(fresher -> fresher.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setCode(dto.getCode());
        project.setName(dto.getName());
        project.setManager(dto.getManager());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setLanguage(dto.getLanguage());
        project.setStatus(Project.Status.valueOf(dto.getStatus()));
        // Relationships are typically managed separately
        return project;
    }
}
