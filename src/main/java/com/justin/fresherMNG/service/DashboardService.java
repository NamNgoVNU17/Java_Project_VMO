package com.justin.fresherMNG.service;

import com.justin.fresherMNG.repository.FresherRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {
    private final FresherRepository fresherRepository;

    public DashboardService(FresherRepository fresherRepository) {
        this.fresherRepository = fresherRepository;
    }

    public Map<String, Long> getFresherCountByCenter() {
        List<Object[]> results = fresherRepository.countFresherByCenter();
        Map<String, Long> fresherCountByCenter = new HashMap<>();
        for (Object[] result : results) {
            fresherCountByCenter.put((String) result[0], (Long) result[1]);
        }
        return fresherCountByCenter;
    }

    public Map<String, Long> getFresherCountByScore() {
        List<Object[]> results = fresherRepository.countFreshersByScore();
        Map<String, Long> fresherCountByScore = new HashMap<>();
        for (Object[] result : results) {
            fresherCountByScore.put((String) result[0], (Long) result[1]);
        }
        return fresherCountByScore;
    }
}
