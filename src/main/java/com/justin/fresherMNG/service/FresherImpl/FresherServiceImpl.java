package com.justin.fresherMNG.service.FresherImpl;

import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Center;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.entity.Project;
import com.justin.fresherMNG.exception.ResourceNotFoundException;
import com.justin.fresherMNG.mapper.FresherMapper;
import com.justin.fresherMNG.mapper.ProjectMapper;
import com.justin.fresherMNG.repository.CenterRepository;
import com.justin.fresherMNG.repository.FresherRepository;
import com.justin.fresherMNG.repository.ProjectRepository;
import com.justin.fresherMNG.service.FresherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class FresherServiceImpl implements FresherService {
    private final FresherRepository fresherRepository;
    private final CenterRepository centerRepository;
    private final ProjectRepository projectRepository;

    public FresherServiceImpl(FresherRepository fresherRepository, CenterRepository centerRepository, ProjectRepository projectRepository) {
        this.fresherRepository = fresherRepository;
        this.centerRepository = centerRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<FresherDTO> getAllFresher() {
        List<Fresher> freshers = fresherRepository.findAll();
        return freshers.stream().map(FresherMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public FresherDTO createFresher(FresherDTO fresherDTO) {
        Fresher fresher = FresherMapper.toEntity(fresherDTO);
        fresher = fresherRepository.save(fresher);
        return FresherMapper.toDTO(fresher);
    }

    @Override
    public void deleteFresherById(Integer fresherId) {
        Fresher fresher = fresherRepository.findById(fresherId).orElseThrow(() -> new ResourceNotFoundException("Fresher is not exist !"));
        fresherRepository.delete(fresher);
    }

    @Override
    public FresherDTO updateFresher(Integer fresherId, FresherDTO fresherDTO) {
        Fresher fresher = fresherRepository.findById(fresherId)
                .orElseThrow(() -> new ResourceNotFoundException("Fresher not found !"));
        fresher.setName(fresherDTO.getName());
        fresher.setEmail(fresherDTO.getEmail());
        fresher.setProgrammingLanguage(fresherDTO.getProgrammingLanguage());
        fresher.setScore1(fresherDTO.getScore1());
        fresher.setScore2(fresherDTO.getScore2());
        fresher.setScore3(fresherDTO.getScore3());
        fresher.setAvgScore(fresherDTO.calAvgScore());
        fresher = fresherRepository.save(fresher);
        return FresherMapper.toDTO(fresher);
    }

    @Override
    public FresherDTO getFresherById(Integer fresherId) {
        Fresher fresher = fresherRepository.findById(fresherId).orElseThrow(() -> new ResourceNotFoundException("Fresher not found"));
        return FresherMapper.toDTO(fresher);
    }

    @Override
    public List<FresherDTO> getFresherByName(String fresherName) {
        List<Fresher> freshers = fresherRepository.findByNameContaining(fresherName);
        return freshers.stream().map(FresherMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<FresherDTO> getFresherByProgramming(String fresherprogrammingLanguage) {
        List<Fresher> freshers = fresherRepository.findByProgrammingLanguage(fresherprogrammingLanguage);
        return freshers.stream().map(FresherMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public FresherDTO getFresherByEmail(String fresherEmail) {
        Fresher fresher = fresherRepository.findByEmail(fresherEmail);
        return FresherMapper.toDTO(fresher);
    }

    @Override
    public void addFresherToCenter(Integer fresherId, Integer centerId) {
        Fresher fresher = fresherRepository.findById(fresherId).orElseThrow(() -> new ResourceNotFoundException("Fresher not found !"));
        Center center = centerRepository.findById(centerId).orElseThrow(() -> new ResourceNotFoundException("Not found Center !"));
        fresher.setCenter(center);
        fresherRepository.save(fresher);
    }

    @Override
    public Set<ProjectDTO> getProjectByFresherId(Integer fresherId) {
        Fresher fresher = fresherRepository.findById(fresherId)
                .orElseThrow(() -> new ResourceNotFoundException("Fresher Not Found !!!"));
        Set<Project> projects = fresher.getProjects();
        return projects.stream().map(ProjectMapper::toDTO).collect(Collectors.toSet());
    }
}
