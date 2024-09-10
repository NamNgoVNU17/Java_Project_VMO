package com.justin.fresherMNG.service;

import com.justin.fresherMNG.dto.ProjectDTO;

public interface ProjectService {
    ProjectDTO createProject (ProjectDTO projectDTO);
    ProjectDTO updateProject (Integer projectId,ProjectDTO projectDTO);
    void deleteProject(Integer projectId);
    void addFresherToProject(Integer fresherId, Integer projectId);
    void deleteFresherFromProject(Integer fresherId, Integer projectId);
}
