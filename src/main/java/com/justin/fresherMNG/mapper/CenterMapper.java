package com.justin.fresherMNG.mapper;

import com.justin.fresherMNG.dto.CenterDTO;
import com.justin.fresherMNG.entity.Center;

import java.util.stream.Collectors;

public class CenterMapper {
    public static CenterDTO toDTO(Center center) {
        CenterDTO dto = new CenterDTO();
        dto.setId(center.getId());
        dto.setName(center.getName());
        dto.setFresherIds(center.getFreshers().stream()
                .map(fresher -> fresher.getId())
                .collect(Collectors.toList()));
        dto.setProjectIds(center.getProjects().stream()
                .map(project -> project.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Center toEntity(CenterDTO dto) {
        Center center = new Center();
        center.setId(dto.getId());
        center.setName(dto.getName());
        // Relationships are typically managed separately
        return center;
    }
}
