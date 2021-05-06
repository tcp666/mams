package com.mams.mamsstudent.service;

import com.mams.mamsstudent.entity.StudentBaseInfo;
import com.mams.mamsstudent.entity.StudentRealNameInfo;

import java.util.List;

/**
 * @InterfaceName StudentBaseInfoService
 * @Description TODO
 * @Author Haining
 * @Date 2021/4/15 14:32
 * @Version 1.0
 */

public interface StudentBaseInfoService {
	Integer save(StudentBaseInfo studentBaseInfo);
	
	List<StudentBaseInfo> findByStudentId(StudentRealNameInfo info);
}
