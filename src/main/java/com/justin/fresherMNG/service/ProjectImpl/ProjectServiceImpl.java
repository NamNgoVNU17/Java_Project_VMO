package com.justin.fresherMNG.service.ProjectImpl;

import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Center;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.entity.Project;
import com.justin.fresherMNG.exception.ResourceNotFoundException;
import com.justin.fresherMNG.mapper.ProjectMapper;
import com.justin.fresherMNG.repository.CenterRepository;
import com.justin.fresherMNG.repository.FresherRepository;
import com.justin.fresherMNG.repository.ProjectRepository;
import com.justin.fresherMNG.service.EmailService;
import com.justin.fresherMNG.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final EmailService emailService;
    private final FresherRepository fresherRepository;
    private final ProjectRepository projectRepository;
    private final CenterRepository centerRepository;

    public ProjectServiceImpl(EmailService emailService, FresherRepository fresherRepository, ProjectRepository projectRepository, CenterRepository centerRepository) {
        this.emailService = emailService;
        this.fresherRepository = fresherRepository;
        this.projectRepository = projectRepository;
        this.centerRepository = centerRepository;
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = ProjectMapper.toEntity(projectDTO);

        //Lay Center theo Id
        Center center = centerRepository.findById(projectDTO.getCenterId()).orElseThrow(() -> new ResourceNotFoundException("Not found Center !"));
        project.setCenter(center);

        if (projectDTO.getFresherIds() != null) {
            Set<Fresher> freshers = new HashSet<>();
            for (Integer fresherId : projectDTO.getFresherIds()) {
                Fresher fresher = fresherRepository.findById(fresherId)
                        .orElseThrow(() -> new ResourceNotFoundException("Not found Fresher !"));
                freshers.add(fresher);
            }
            project.setFreshers(freshers);
        }
        projectRepository.save(project);
        return ProjectMapper.toDTO(project);
    }

    @Override
    public ProjectDTO updateProject(Integer projectId,ProjectDTO projectDTO) {
        deleteProject(projectId);
        return createProject(projectDTO);
    }

    @Override
    public void deleteProject(Integer projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project not found");
        }
        projectRepository.deleteById(projectId);
    }

    @Override
    public void addFresherToProject(Integer fresherId, Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new ResourceNotFoundException("Project not found !!!"));
        Fresher fresher = fresherRepository.findById(fresherId).orElseThrow(() -> new ResourceNotFoundException("Fresher not found !!!"));

        project.getFreshers().add(fresher);
        fresher.getProjects().add(project);

        projectRepository.save(project);
        fresherRepository.save(fresher);

        emailService.sendProjectNotification(fresher.getEmail(),"Thêm vào dự án","Bạn đã được thêm vào dự án: "+project.getName());

    }

    @Override
    public void deleteFresherFromProject(Integer fresherId, Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new ResourceNotFoundException("Project not found !!!"));
        Fresher fresher = fresherRepository.findById(fresherId).orElseThrow(() -> new ResourceNotFoundException("Fresher not found !!!"));

        project.getFreshers().remove(fresher);
        fresher.getProjects().remove(project);

        projectRepository.save(project);
        fresherRepository.save(fresher);

        emailService.sendProjectNotification(fresher.getEmail(),"Xóa khỏi dự án","Bạn đã bị xóa khỏi dự án: "+project.getName());
    }


}
