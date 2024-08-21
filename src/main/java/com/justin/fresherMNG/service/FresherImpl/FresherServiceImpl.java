package com.justin.fresherMNG.service.FresherImpl;

import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.exception.ResourceNotFoundException;
import com.justin.fresherMNG.mapper.FresherMapper;
import com.justin.fresherMNG.repository.FresherRepository;
import com.justin.fresherMNG.service.FresherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FresherServiceImpl implements FresherService {
    private final FresherRepository fresherRepository;

    public FresherServiceImpl(FresherRepository fresherRepository) {
        this.fresherRepository = fresherRepository;
    }

    @Override
    public List<FresherDTO> getAllFresher() {
        List<Fresher> freshers = fresherRepository.findAll();
        return freshers.stream().map((fresher) -> FresherMapper.toDTO(fresher)).collect(Collectors.toList());
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
        fresher = fresherRepository.save(fresher);
        return FresherMapper.toDTO(fresher);
    }
}
