package com.mams.mamscommon.service.impl;

import com.mams.mamscommon.mapper.SubjectMapper;
import com.mams.mamscommon.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName SubjectServiceImpl
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/4/19 20:33
 *@Version 1.0
 */@Service
public class SubjectServiceImpl implements SubjectService {

 	@Resource
 	SubjectMapper subjectMapper;
	
	@Override
	public List<String> getAllSubjectName() {
		return subjectMapper.getAllSubjectName();
	}
	
	@Override
	public List<String> getAllDeptName() {
		return subjectMapper.getAllDeptName();
		
	}
}

