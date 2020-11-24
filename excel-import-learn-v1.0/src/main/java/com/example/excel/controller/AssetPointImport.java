package com.example.excel.controller;

import com.example.excel.entity.AssetPointEntity_HI;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Cool 真正直接用于本地导入的
 * @create 2020-09-22 15:19
 */
@RestController("/excel")
public class AssetPointImport {
    @ApiOperation(value = "导入excel数据到数据库", notes = "导入excel数据到数据库")
    @GetMapping("/import-datas")
    public  void readExcelData() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\拉萨项目采集数据 20190821(1).xlsx");

        //.xlsx
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //.xls
        //HSSFWorkbook workbook1 = new HSSFWorkbook(fileInputStream);

        //excel文件里面第3个表
        Sheet sheet = workbook.getSheetAt(2);
        List<Map<String, String>> result = new ArrayList<>();
        int rowNumber = sheet.getPhysicalNumberOfRows();

        
        List<AssetPointEntity_HI> beans = new ArrayList<>();
        //从第三行开始读数据
        for (int i = 2; i < rowNumber; i++) {
            Row formal = sheet.getRow(i);

            AssetPointEntity_HI assetPointEntity_HI = new AssetPointEntity_HI();
            assetPointEntity_HI.setPointName(getValueOnCell(formal.getCell(1)));
            assetPointEntity_HI.setAssetType("85");
            assetPointEntity_HI.setPointKey(getValueOnCell(formal.getCell(3)));
            assetPointEntity_HI.setPointProperty(getValueOnCell(formal.getCell(4)));
            assetPointEntity_HI.setRemark(getValueOnCell(formal.getCell(7)) + " " + getValueOnCell(formal.getCell(8)));
            assetPointEntity_HI.setTenantId("1eaf272f05f1c6093efb199fd3425b2");
            assetPointEntity_HI.setPointStatus(true);
            beans.add(assetPointEntity_HI);

        }

        System.out.println(beans.size());
        System.out.println(beans);
        try {
            //数据库导入操作

            //assetPointServer.save(beans);
            //assetPointServer.save(beans.get(0));

        } catch (Exception e) {
            //throw  new ApplicationRuntimeException(e.getMessage());
            System.out.println("数据库操作失败");
        }
    }



    private static String getValueOnCell(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getStringCellValue();
//            case NUMERIC: return String.format("%.2f", cell.getNumericCellValue());
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return cell.getBooleanCellValue() ? "true" : "false";
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (Exception e) {
//                    return String.format("%.2f", cell.getNumericCellValue());
                    return String.valueOf(cell.getNumericCellValue());
                }
            default:
                return "";
        }

    }
}
