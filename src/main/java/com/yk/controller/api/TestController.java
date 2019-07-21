package com.yk.controller.api;

import com.yk.util.ResponseUtil;
import com.yk.util.ResultVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chaizi
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public ResultVO excel(){
        List<Map<String,Object>> list = new ArrayList<>();
        String excelPath = "/Users/chaizi/个人项目/sihuo/ui/中讯官网页面说明0705/中讯官网页面说明0705/科研成果与历史荣誉/科研成果/专利项目统计.xls";

        try{

            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return ResponseUtil.error(500,"文件未找到");
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    System.out.println("row="+row);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        Map<String,Object> map = new HashMap();
                        map.put("id",rIndex);
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                switch (cIndex){
                                    case 1:{
                                        map.put("title",cell.toString());
                                        break;
                                    }
                                    case 2:{
                                        map.put("type",cell.toString());
                                        break;
                                    }
                                    case 3:{
                                        map.put("org",cell.toString());
                                        break;
                                    }
                                    case 4:{
                                        map.put("code",cell.toString());
                                        break;
                                    }
                                    case 5:{
                                        map.put("owner",cell.toString());
                                        break;
                                    }
                                    case 6:{
                                        String date = cell.toString();
                                        String [] time = date.split("\\-");
                                        String[] month = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
                                        System.out.println("length:"+month.length);
                                        for(int i=0;i<month.length;i++){
                                            if (i==10){
                                                time[1] = time[1].replace("十","1");
                                            }
                                            time[1] = time[1].replace(month[i],String.valueOf(i+1));
                                        }
                                        System.out.println("time="+time[1]);
                                        map.put("date",time[2]+"/"+time[1]+"/"+time[0]);
                                        break;
                                    }default:{
                                        System.out.println("xxxx");
                                        break;
                                    }
                                }

                            }
                        }
                        list.add(map);
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseUtil.success(list);
    }
}
