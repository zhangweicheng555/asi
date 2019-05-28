package com.boot.kaizen.service;

import java.util.List;

import com.boot.kaizen.model.ParamTest;
import com.boot.kaizen.model.SysTest;


public interface SysTestService {

	public List<SysTest> findTest();

	public List<SysTest> findTest(int pageNum,int pageSize);

	public List<SysTest> findTest(ParamTest paramTest);
}
