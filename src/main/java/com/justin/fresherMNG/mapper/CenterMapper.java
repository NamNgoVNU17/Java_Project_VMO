package com.justin.fresherMNG.mapper;

import com.justin.fresherMNG.dto.CenterDTO;
import com.justin.fresherMNG.entity.Center;

public class CenterMapper {
    public static CenterDTO toDTO (Center center) {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setId(center.getId());
        centerDTO.setName(center.getName());
        centerDTO.setLocation(center.getLocation());

        return centerDTO;
    }


    public static Center toCenter (CenterDTO centerDTO) {
        Center center = new Center();
        center.setId(centerDTO.getId());
        center.setName(centerDTO.getName());
        center.setLocation(centerDTO.getLocation());

        return center;
    }
}
