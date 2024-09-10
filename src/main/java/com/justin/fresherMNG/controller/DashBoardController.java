package com.justin.fresherMNG.controller;

import com.justin.fresherMNG.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/dashboard")
public class DashBoardController {
    private final DashboardService dashboardService;

    public DashBoardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/freshers-by-center")
    public ResponseEntity<Map<String, Long>> getFresherCountByCenter() {
        Map<String, Long> result = dashboardService.getFresherCountByCenter();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/freshers-by-score")
    public ResponseEntity<Map<String, Long>> getFresherCountByScore() {
        Map<String, Long> result = dashboardService.getFresherCountByScore();
        return ResponseEntity.ok(result);
    }
}
