package com.qfedu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.qfedu.service.SysRightService;
import com.qfedu.vo.VMenuInfo;

public class MenueTest extends BaseTest {

	@Autowired
	private SysRightService rightService;
	
	@Test
	public void menu() {
		List<VMenuInfo> list = rightService.findMenue(1);
		for (VMenuInfo vMenuInfo : list) {
			System.out.println(vMenuInfo.getMenuName());
			System.out.println("......");
			for (VMenuInfo m : vMenuInfo.getMenulist()) {
				System.out.println(m.getMenuName());
			}
		}
	}
}
