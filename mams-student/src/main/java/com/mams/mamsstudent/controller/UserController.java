package com.mams.mamsstudent.controller;


import com.mams.mamsstudent.entity.StudentRealNameInfo;
import com.mams.mamsstudent.service.StudentRealNameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mams.mamscommon.utils.Result;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class UserController {
	@Autowired
	StudentRealNameInfoService studentRealNameInfoService;
	
	@RequestMapping("/getAllUser")
	public Result<String> getAllUser() {
		return Result.success(studentRealNameInfoService.getAll());
	}
	
	@RequestMapping("/register")
	public Result<StudentRealNameInfo> register(StudentRealNameInfo studentRealNameInfo) {
		if (studentRealNameInfo.getPassword() == null)
			return Result.fail("password 为空!");
		if (studentRealNameInfo.getUserName() == null)
			return Result.fail("username 为空!");
		if (studentRealNameInfo.getEmail() == null)
			return Result.fail("email 为空!");
		if (studentRealNameInfoService.register(studentRealNameInfo) > 0)
			return Result.success(studentRealNameInfo);
		return Result.fail(studentRealNameInfo);
	}
}
