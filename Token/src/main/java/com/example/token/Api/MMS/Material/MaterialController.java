package com.example.token.Api.MMS.Material;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.material.MaterialBO;
import com.example.token.Service.MMSService.MaterialService.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/material")
@Api(tags = "物料信息")
public class MaterialController {
    @Autowired
    @Qualifier("MaterialService1")
    private MaterialService materialService;

    @UserLoginToken
    @GetMapping("/getAllMaterial")
    @ResponseBody
    @ApiOperation("获取物料信息")
    @AspectLogAnnptation
    public List<MaterialBO> getAllMaterial(){
        return materialService.GetAllMaterial();
    }

    @UserLoginToken
    @GetMapping("/getAllMaterial/{id}")
    @ResponseBody
    @ApiOperation("获取某个物料信息")
    @AspectLogAnnptation
    public MaterialBO getAllMaterialByName(@PathVariable String material_id){
        return materialService.GetMaterialByName(material_id);
    }


}
