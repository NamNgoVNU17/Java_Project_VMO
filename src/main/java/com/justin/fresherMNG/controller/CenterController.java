package com.justin.fresherMNG.controller;


import com.justin.fresherMNG.dto.CenterDTO;
import com.justin.fresherMNG.service.CenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/centers")
public class CenterController {
    private final CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }
    @GetMapping
    public ResponseEntity<List<CenterDTO>> getAllCenter() {
        List<CenterDTO> centerDTOS = centerService.getAllCenter();
        return ResponseEntity.ok(centerDTOS);
    }


    @PostMapping
    public ResponseEntity<CenterDTO> createCenter(@RequestBody CenterDTO centerDTO) {
        return ResponseEntity.ok(centerService.createCenter(centerDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCenter(@PathVariable("id") Integer centerId) {
        centerService.deleteCenter(centerId);
        return ResponseEntity.ok("Da xoa center co id la : "+ centerId);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<CenterDTO> updateCenter(@PathVariable("id") Integer centerId,@RequestBody CenterDTO centerDTO) {
        CenterDTO centerDTOupdate = centerService.updateCenter(centerId, centerDTO);
        return ResponseEntity.ok(centerDTOupdate);
    }

}
