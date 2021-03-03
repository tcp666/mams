package com.mams.mamsstudent.service;

import com.mams.mamsstudent.entity.StudentRealNameInfo;

import java.util.List;

/**
 * @ClassName StudentRealNameInfoService
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:48
 * @Version 1.0
 */

public interface StudentRealNameInfoService {
	List<StudentRealNameInfo> getAll();
	
	//注册
	Integer register(StudentRealNameInfo studentRealNameInfo);
	
	//登录
	List<StudentRealNameInfo> login(StudentRealNameInfo info);
}
