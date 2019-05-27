package com.qfedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.BaseDictMapper;
import com.qfedu.entity.BaseDict;
import com.qfedu.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictDao;
	@Override
	public List<BaseDict> findBaseDicts() {
		
		return null;
	}

}
