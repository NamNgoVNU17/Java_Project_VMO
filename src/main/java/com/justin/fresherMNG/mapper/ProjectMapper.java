package com.justin.fresherMNG.mapper;

import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.entity.Project;
import com.justin.fresherMNG.repository.ProjectRepository;

import java.util.stream.Collectors;

public class ProjectMapper {
    public static ProjectDTO toDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        projectDTO.setProgrammingLanguage(project.getProgrammingLanguage());
        if (project.getStatus() != null) {
            projectDTO.setStatus(project.getStatus());
        }
        if (project.getStartDate() != null) {
            projectDTO.setStartDate(project.getStartDate());
        }
        if (project.getEndDate() != null) {
            projectDTO.setEndDate(project.getEndDate());
        }
        projectDTO.setCenterId(project.getCenter().getId());
        if (project.getFreshers() != null) {
            projectDTO.setFresherIds(project.getFreshers().stream().map(Fresher::getId).collect(Collectors.toSet()));
        }
        return projectDTO;
    }
    public static Project toEntity(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setProgrammingLanguage(projectDTO.getProgrammingLanguage());
        project.setStatus(projectDTO.getStatus());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        return project;
    }
}
