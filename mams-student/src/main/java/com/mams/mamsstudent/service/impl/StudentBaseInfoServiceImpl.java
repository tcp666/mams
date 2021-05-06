package com.mams.mamsstudent.service.impl;

import com.mams.mamsstudent.entity.StudentBaseInfo;
import com.mams.mamsstudent.entity.StudentRealNameInfo;
import com.mams.mamsstudent.mapper.StudentBaseInfoMapper;
import com.mams.mamsstudent.service.StudentBaseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName StudentBaseInfoServiceImpl
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/4/15 14:33
 *@Version 1.0
 */
@Service
public class StudentBaseInfoServiceImpl implements StudentBaseInfoService {
	
	@Resource
	StudentBaseInfoMapper studentBaseInfoMapper;
	@Override
	public Integer save(StudentBaseInfo studentBaseInfo) {
		return studentBaseInfoMapper.save(studentBaseInfo);
	}
	
	@Override
	public List<StudentBaseInfo> findByStudentId(StudentRealNameInfo info) {
		return studentBaseInfoMapper.findByStudentId(info);
	}
}
