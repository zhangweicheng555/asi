package com.boot.kaizen.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.kaizen.dao.SysDinctionaryDao;
import com.boot.kaizen.model.SysDic;
import com.boot.kaizen.service.SysDictionaryService;

@Service
public class SysDinctionaryServiceImpl implements SysDictionaryService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private SysDinctionaryDao dinctionaryDao;

	@Override
	public List<SysDic> findByType(String type) {
		return dinctionaryDao.findByType(type);
	}

	

}
