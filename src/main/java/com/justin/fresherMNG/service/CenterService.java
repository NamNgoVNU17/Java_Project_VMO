package com.justin.fresherMNG.service;

import com.justin.fresherMNG.dto.CenterDTO;

import java.util.List;

public interface CenterService {
    List<CenterDTO> getAllCenter();
    CenterDTO createCenter (CenterDTO centerDTO);
    void deleteCenter(Integer centerId);
    CenterDTO updateCenter(Integer centerId, CenterDTO centerDTO);
}
