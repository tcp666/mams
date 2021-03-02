package com.mams.mamsstudent.controller;


import com.mams.mamscommon.utils.Verify;
import com.mams.mamsstudent.entity.StudentRealNameInfo;
import com.mams.mamsstudent.service.StudentRealNameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mams.mamscommon.utils.Result;

import javax.mail.MessagingException;

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
	@ResponseBody
	public Result<StudentRealNameInfo> register(@RequestBody StudentRealNameInfo studentRealNameInfo) {
		System.out.println(studentRealNameInfo);
		if (studentRealNameInfo.getPassword() == "")
			return Result.fail("password 为空!");
		if (studentRealNameInfo.getUserName() == "")
			return Result.fail("username 为空!");
		if (studentRealNameInfo.getEmail() == "")
			return Result.fail("email 为空!");
		if (studentRealNameInfoService.register(studentRealNameInfo) > 0)
			return Result.success(studentRealNameInfo);
		return Result.fail(studentRealNameInfo);
	}
	@RequestMapping("/sendCheckCode")
	@ResponseBody
	public Result<String> sendCheckCode(@RequestBody StudentRealNameInfo info) throws MessagingException {
		return Result.success(Verify.sendMsg(info.getEmail(),Verify.getCheckCode()));
	}
}
