package com.mams.mamscommon.entity;

import lombok.Data;

/**
 *@ClassName User
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/2 12:39
 *@Version 1.0
 */
@Data
public class User {
	private Integer userId;
	private String userName;
	private String password;
	private String idNumber;
	private String email;
}
