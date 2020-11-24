package com.example.excel.controller;

import com.example.excel.entity.UserDto;
import io.swagger.annotations.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.*;



/**
 * @author Cool 自己写的
 * @create 2020-09-21 10:59
 */
@RestController("/demo1")
@Api(tags = "导入Excel文件")
public class ExcelDemoController {


    @PostMapping(value = "/import")
    public String importData(@ApiParam(value = "用户信息Excel导入数据", required = true) MultipartFile file) throws IOException {
        //将文件转成workbook类型
        Workbook workbook = null;
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else if (fileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            return "请导入一个excel文件";
        }

        //
        Sheet sheet = workbook.getSheetAt(0);
        List<Map<String, String>> result = new ArrayList<>();
        int rowNumber = sheet.getPhysicalNumberOfRows();

        //表头，用于Map时的key
        String[] titles;
        Row row = sheet.getRow(0);
        if (row == null) {
            titles = new String[]{};
        } else {
            int cellNumber = row.getLastCellNum();
            List<String> cellValueList = new ArrayList<>();
            for (int i = 0; i < cellNumber; i++) {
                Cell cell = row.getCell(i);
                cellValueList.add(getValueOnCell(cell));
            }
            titles = cellValueList.toArray(new String[0]);
        }

        //从第三行开始读数据
        for (int i = 3; i < rowNumber; i++) {
            Row formal = sheet.getRow(i);
            int numberOfCells = formal.getPhysicalNumberOfCells();
            List<String> formalValues = new ArrayList<>();

            for (int j = 1; j < numberOfCells; j++) {
                String valueOnCell = getValueOnCell(row.getCell(j));
                formalValues.add(valueOnCell);
            }
            String[] values = formalValues.toArray(new String[0]);


            Map<String, String> valueMap = new HashMap<>();
            for (int j = 0; j < titles.length; j++) {
                valueMap.put(titles[j], values[j]);
            }
            result.add(valueMap);
        }

        List<UserDto> response = new ArrayList<>();
        for (Map<String, String> map : result) {
            response.add(buildDTOByClass(UserDto.class, map));
        }

        System.out.println(response);

        try {
            //数据库导入操作
            return response.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static <T> T buildDTOByClass(Class<T> clazz, Map<String, String> valueMap) {
        try {
            T dto = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                ApiModelProperty desc = field.getAnnotation(ApiModelProperty.class);
                String value = valueMap.get(desc.value());
                if (value != null) {
                    if (field.getType().getName().equalsIgnoreCase("java.lang.Integer")) {
                        Method method = clazz.getMethod(getSetMethodName(field.getName()), field.getType());
                        Integer age = Integer.parseInt(value.substring(0, value.indexOf(".")));
                        method.invoke(dto, age);
                    } else {
                        Method method = clazz.getMethod(getSetMethodName(field.getName()), field.getType());
                        method.invoke(dto, value);
                    }
                }
            }

            return dto;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    private static String getSetMethodName(String name) {
        String firstChar = name.substring(0, 1);
        return "set" + firstChar.toUpperCase() + name.substring(1);
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


    @GetMapping("/file/{fileName}")
    public static List<Object[]> importExcel(@PathVariable("fileName") String fileName) {
        //log.info("导入解析开始，fileName:{}",fileName);
        try {
            List<Object[]> list = new ArrayList<>();
            InputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rows; i++) {
                //过滤表头行
                if (i == 0) {
                    continue;
                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
                Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (cell.getCellType().equals(NUMERIC)) {
                        objects[index] = (int) cell.getNumericCellValue();
                    }
                    if (cell.getCellType().equals(STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    if (cell.getCellType().equals(BOOLEAN)) {
                        objects[index] = cell.getBooleanCellValue();
                    }
                    if (cell.getCellType().equals(ERROR)) {
                        objects[index] = cell.getErrorCellValue();
                    }
                    index++;
                }
                list.add(objects);
            }
            //log.info("导入文件解析成功！");
            return list;
        }catch (Exception e){
            //log.info("导入文件解析失败！");
            e.printStackTrace();
        }
        return null;
    }



}
