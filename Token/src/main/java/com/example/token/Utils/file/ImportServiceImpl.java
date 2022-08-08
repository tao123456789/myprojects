package com.example.token.Utils.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ImportServiceImpl {
    /**
     * 处理上传的文件
     *
     * @param inputStream
     * @param fileName
     * @return
     * @throws Exception
     */
    public List getBankListByExcel(InputStream inputStream, String fileName) throws Exception {

        final XSSFWorkbook xssfWorkbook=new XSSFWorkbook(inputStream);
        Sheet sheet=xssfWorkbook.getSheetAt(0);//获取第一个表的数据

        List<Object> list = new ArrayList<>();
        for(int i=sheet.getFirstRowNum();i<sheet.getLastRowNum();i++){
            List<String> temp = new ArrayList<>();
            Row headRow=sheet.getRow(i);//获取第i行的数据
            for(int j=headRow.getFirstCellNum();j<headRow.getLastCellNum();j++){
                temp.add(headRow.getCell(j).toString());
            }
            if(temp.get(1).toString().equals("花小月")) {
                log.info(i + "行数据：" + temp);
            }
        }

        xssfWorkbook.close();
        return list;
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }
}
