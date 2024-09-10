package com.justin.fresherMNG.controller;


import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.dto.ProjectDTO;
import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.mapper.FresherMapper;
import com.justin.fresherMNG.service.CenterService;
import com.justin.fresherMNG.service.FresherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/freshers")
public class FresherController {
    private final FresherService fresherService;
    private final CenterService centerService;
    public FresherController(FresherService fresherService, CenterService centerService) {
        this.centerService = centerService;
        this.fresherService = fresherService;
    }
    @GetMapping
    public ResponseEntity<List<FresherDTO>> getAllFresher() {
        List<FresherDTO> fresherDTOS = fresherService.getAllFresher();
        return ResponseEntity.ok(fresherDTOS);
    }

    @PostMapping
    public ResponseEntity<FresherDTO> createFresher(@RequestBody FresherDTO fresherDTO) {
        return ResponseEntity.ok(fresherService.createFresher(fresherDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteFresherById(@PathVariable("id") Integer fresherId) {
        fresherService.deleteFresherById(fresherId);
        return ResponseEntity.ok("Da xoa Fresher co id la : " + fresherId);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<FresherDTO> updateFresher (@PathVariable("id") Integer fresherId,@RequestBody FresherDTO fresherDTOupdate) {
        FresherDTO fresherDTO = fresherService.updateFresher(fresherId,fresherDTOupdate);
        return ResponseEntity.ok(fresherDTO);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<FresherDTO> getFresherById (@PathVariable("id") Integer fresherId) {
        FresherDTO fresher = fresherService.getFresherById(fresherId);
        return ResponseEntity.ok(fresher);
    }

    @GetMapping("getByName/{name}")
    public ResponseEntity<List<FresherDTO>> getFresherByName(@PathVariable("name") String fresherName) {
        List<FresherDTO> fresherDTOS = fresherService.getFresherByName(fresherName);
        return ResponseEntity.ok(fresherDTOS);
    }

    @GetMapping("getByProg/{programlang}")
    public ResponseEntity<List<FresherDTO>> getFresherByProgram(@PathVariable("programlang") String proglang) {
        List<FresherDTO> fresherDTOS = fresherService.getFresherByProgramming(proglang);
        return ResponseEntity.ok(fresherDTOS);
    }

    @GetMapping("getByEmail/{email}")
    public ResponseEntity<FresherDTO> getFresherByEmail(@PathVariable("email") String email) {
        FresherDTO fresherDTO = fresherService.getFresherByEmail(email);
        return ResponseEntity.ok(fresherDTO);
    }

    @PutMapping("add/{fresherid}/to/{centerId}")
    public ResponseEntity<String> addFresherToCenter(@PathVariable("fresherid") Integer fresherId,@PathVariable("centerId") Integer centerId) {
        fresherService.addFresherToCenter(fresherId,centerId);
        return ResponseEntity.ok("Da them Fresher co id "+fresherId+" vao Center co id "+centerId);
    }

    @GetMapping("projectOf/{fresherId}")
    public ResponseEntity<Set<ProjectDTO>> getFreshersByProjectId (@PathVariable("fresherId") Integer fresherId) {
        Set<ProjectDTO> projectDTOS = fresherService.getProjectByFresherId(fresherId);
        return ResponseEntity.ok(projectDTOS);
    }
}
