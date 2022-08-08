package com.example.token.Service.MMSService.MaterialService.Impl;

import com.example.token.Entity.BO.material.MaterialBO;
import com.example.token.Mapper.MaterialMapper;
import com.example.token.Service.MMSService.MaterialService.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MaterialService1")
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private MaterialMapper materialMapper;

    @Override
    public MaterialBO GetMaterialByName(String material_id){
        return materialMapper.GetMaterialByName(material_id);
    };

    @Override
    public List<MaterialBO> GetAllMaterial(){
        return materialMapper.GetAllMaterial();
    };
}
