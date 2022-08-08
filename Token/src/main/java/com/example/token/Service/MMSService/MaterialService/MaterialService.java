package com.example.token.Service.MMSService.MaterialService;

import com.example.token.Entity.BO.material.MaterialBO;

import java.util.List;

public interface MaterialService {
    MaterialBO GetMaterialByName(String material_id);
    List<MaterialBO> GetAllMaterial();
}
