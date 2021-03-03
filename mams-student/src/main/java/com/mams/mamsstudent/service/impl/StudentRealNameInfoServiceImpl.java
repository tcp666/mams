package com.mams.mamsstudent.service.impl;

import com.mams.mamsstudent.entity.StudentRealNameInfo;
import com.mams.mamsstudent.mapper.StudentRealNameInfoMapper;
import com.mams.mamsstudent.service.StudentRealNameInfoService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StudentRealNameInfoServiceImpl
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:50
 * @Version 1.0
 */
@Service
public class StudentRealNameInfoServiceImpl implements StudentRealNameInfoService {
	@Resource
	private StudentRealNameInfoMapper studentRealNameInfoMapper;
	
	@Override
	public List<StudentRealNameInfo> getAll() {
		return studentRealNameInfoMapper.getAllUser();
	}
	
	@Override
	public Integer register(StudentRealNameInfo studentRealNameInfo) {
		return studentRealNameInfoMapper.register(studentRealNameInfo);
	}
	
	@Override
	public List<StudentRealNameInfo> login(StudentRealNameInfo info) {
		List<StudentRealNameInfo> login = studentRealNameInfoMapper.login(info);
		if (login.size()!=1)
			new Exception("没有这个人");
		return login;
	}
}
