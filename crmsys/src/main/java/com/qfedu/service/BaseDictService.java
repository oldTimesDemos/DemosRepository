package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.BaseDict;

public interface BaseDictService {
	
	/**
	 * 	查看所有的数据字典条目
	 * @return
	 */
	public List<BaseDict> findBaseDicts();
}
