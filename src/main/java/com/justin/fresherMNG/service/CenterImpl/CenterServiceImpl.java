package com.justin.fresherMNG.service.CenterImpl;

import com.justin.fresherMNG.dto.CenterDTO;
import com.justin.fresherMNG.entity.Center;
import com.justin.fresherMNG.exception.ResourceNotFoundException;
import com.justin.fresherMNG.mapper.CenterMapper;
import com.justin.fresherMNG.repository.CenterRepository;
import com.justin.fresherMNG.service.CenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CenterServiceImpl implements CenterService {
    private final CenterRepository centerRepository;

    public CenterServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }



    @Override
    public List<CenterDTO> getAllCenter() {
        List<Center> centers = centerRepository.findAll();
        return centers.stream().map(CenterMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CenterDTO createCenter(CenterDTO centerDTO) {
        Center center = CenterMapper.toCenter(centerDTO);
        center = centerRepository.save(center);
        return CenterMapper.toDTO(center);
    }

    @Override
    public void deleteCenter(Integer centerId) {
        Center center = centerRepository.findById(centerId).orElseThrow(() -> new ResourceNotFoundException("Fresher not exist !"));
        centerRepository.delete(center);
    }

    @Override
    public CenterDTO updateCenter(Integer centerId, CenterDTO centerDTO) {
        Center center = centerRepository.findById(centerId).orElseThrow(() -> new ResourceNotFoundException("Fresher not found !"));
        if (center != null) {
            center.setName(centerDTO.getName());
            center.setLocation(centerDTO.getLocation());
            center = centerRepository.save(center);
        }
        return CenterMapper.toDTO(center);
    }
}
