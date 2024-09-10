package com.justin.fresherMNG.controller;


import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Integer projectId,@RequestBody ProjectDTO projectDTO){
        return ResponseEntity.ok(projectService.updateProject(projectId,projectDTO));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok("Da xoa Project !!!");
    }

    @PostMapping("/{projectId}/add-fresher/{fresherId}")
    public ResponseEntity<String> addFresherToProject(@PathVariable("projectId") Integer projectId, @PathVariable("fresherId") Integer fresherId) {
        projectService.addFresherToProject(fresherId,projectId);
        return ResponseEntity.ok("Da them Fresher vao Project !");
    }

    // Xóa Fresher khỏi dự án
    @DeleteMapping("/{projectId}/remove-fresher/{fresherId}")
    public ResponseEntity<String> removeFresherFromProject(@PathVariable("projectId") Integer projectId, @PathVariable("fresherId") Integer fresherId) {
        projectService.deleteFresherFromProject(fresherId,projectId);
        return ResponseEntity.ok("Da xoa Fresher ra khoi Project !");
    }
}
