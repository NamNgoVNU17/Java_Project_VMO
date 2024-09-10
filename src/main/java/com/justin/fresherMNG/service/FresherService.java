package com.justin.fresherMNG.service;

import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.entity.Project;

import java.util.List;
import java.util.Set;

public interface FresherService {
    List<FresherDTO> getAllFresher();
    FresherDTO createFresher(FresherDTO fresherDTO);
    void deleteFresherById(Integer fresherId);
    FresherDTO updateFresher(Integer fresherId, FresherDTO fresherDTO);
    FresherDTO getFresherById(Integer fresherId);

    List<FresherDTO> getFresherByName(String fresherName);
    List<FresherDTO> getFresherByProgramming(String fresherprogrammingLanguage);
    FresherDTO getFresherByEmail(String fresherEmail);
    void addFresherToCenter(Integer fresherId, Integer centerId);
    Set<ProjectDTO> getProjectByFresherId(Integer fresherId);
}
