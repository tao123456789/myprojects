package com.example.token.Entity.BO.material;

import lombok.Data;

@Data
public class MaterialBO {

    int id;
    String material_id;
    String material_name;
    String material_type;
    String material_dw;
    String material_price;
    String material_gys;
    String gys_name;
    String gys_name_tel;
    String remark;

    @Override
    public String toString() {
        return "MaterialDo{" +
                "id=" + id +
                ", material_id='" + material_id + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_type='" + material_type + '\'' +
                ", material_dw='" + material_dw + '\'' +
                ", material_price='" + material_price + '\'' +
                ", material_gys='" + material_gys + '\'' +
                ", gys_name='" + gys_name + '\'' +
                ", gys_name_tel='" + gys_name_tel + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
