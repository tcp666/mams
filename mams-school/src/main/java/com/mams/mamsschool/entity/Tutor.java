package com.mams.mamsschool.entity;

import lombok.Data;

/**
 *@ClassName Tutor
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/7 10:03
 *@Version 1.0
 */
@Data
public class Tutor {
	private int tutorId;
	private String realName;
	private String schoolName;
	private String department;
	private String profession;
	private String ID_CODE;
	private String email;
	private String imgSrc;
	private String userName;
	private String password;
	private int checked;
}
