package com.justin.fresherMNG.controller;


import com.justin.fresherMNG.dto.FresherDTO;
import com.justin.fresherMNG.service.FresherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/freshers")
public class FresherController {
    private final FresherService fresherService;

    public FresherController(FresherService fresherService) {
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

}
