package com.qfedu.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.entity.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.utils.ExcelUtils;
import com.qfedu.vo.JsonBean;

@RestController
public class ImportController {

	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/user/import.do")
	public JsonBean importExcel(@RequestParam MultipartFile excelFile) {
		
		try {
			InputStream inputStream = excelFile.getInputStream();
			String filename = excelFile.getOriginalFilename();
			
			List<Map<String,Object>> list = ExcelUtils.readExcel(filename, inputStream);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			String jsonStr = objectMapper.writeValueAsString(list);
			
			List<SysUser> userList = objectMapper.readValue(jsonStr, new TypeReference<List<SysUser>>() {});
			
			userService.importUserInfo(userList);
			return new JsonBean(1, null);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return new JsonBean(0, e.getMessage());
		}
		
		
	}
}
