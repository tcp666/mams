package com.mams.mamscommon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName UserController
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/2 11:35
 *@Version 1.0
 */
@RestController
@RequestMapping("/common")
public class UserController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
