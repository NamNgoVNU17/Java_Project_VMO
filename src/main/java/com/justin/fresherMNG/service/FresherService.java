package com.justin.fresherMNG.service;

import com.justin.fresherMNG.dto.FresherDTO;

import java.util.List;

public interface FresherService {
    List<FresherDTO> getAllFresher();
    FresherDTO createFresher(FresherDTO fresherDTO);
    void deleteFresherById(Integer fresherId);
    FresherDTO updateFresher(Integer fresherId, FresherDTO fresherDTO);

}
