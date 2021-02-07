package com.mams.mamscommon.service;

import com.mams.mamscommon.api.UserService;
import org.springframework.stereotype.Service;

/**
 *@ClassName UserServiceImp
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/7 17:22
 *@Version 1.0
 */
@Service("userService")
public class UserServiceImp implements UserService {
	@Override
	public String getUserName() {
		return "testName";
	}
}
