package com.mams.mamsschool.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String idCode;
	private String email;
	private String imgSrc;
	private String userName;
	private String password;
	private int checked;
}
