package com.qfedu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkFactory {

	public static Workbook creatWorkbook (Boolean flag, InputStream inputStream) throws Exception {
		
		if (flag) {
			return new HSSFWorkbook(inputStream);
		}else {
			return new XSSFWorkbook(inputStream);
		}
	}
}
