package com.qfedu.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelUtils {
	public static List<Map<String, Object>> readExcel(String fileName,InputStream inputStream) throws Exception {

		Workbook workbook = null;

		boolean ret = isxls(fileName);

		workbook = WorkFactory.creatWorkbook(ret, inputStream);

		Sheet sheet = workbook.getSheet("sheet1");
		//	标题行
		Row row = sheet.getRow(0);
		short lastCellNum = row.getLastCellNum();
		List<String> titleList = new ArrayList<>();
		for (int i = 0; i < lastCellNum; i++) {
			Cell cell = row.getCell(i);
			if (cell != null) {
				titleList.add(cell.getStringCellValue());
			}else {
				throw new RuntimeException("格式不正确");
			}
		}
		
		List<Map<String, Object>> list = new ArrayList<>();
		int lastRowNum = sheet.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			Row row2 = sheet.getRow(i);
			Map<String, Object> map = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell = row2.getCell(j);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					map.put(titleList.get(j),cell.getStringCellValue());
				}
			}
			list.add(map);
		}

		workbook.close();
		inputStream.close();
		return list;
	}

	public static boolean isxls(String fileName) {
		if(fileName.matches("^.+\\.(?i)(xls)$")){
			return true;
		}else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
			return false;
		}else{
			throw new RuntimeException("格式不对");
		}
	}
}
