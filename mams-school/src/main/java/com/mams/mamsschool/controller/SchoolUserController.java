package com.mams.mamsschool.controller;

import com.mams.mamscommon.api.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/2/7 17:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
class SchoolUserController {
	@Autowired
	UserService userService;
	@RequestMapping("/getUserName")
	public String getUserName() {
		return userService.getUserName();
	}
}
