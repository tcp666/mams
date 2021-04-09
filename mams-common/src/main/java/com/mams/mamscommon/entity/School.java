package com.mams.mamscommon.entity;

import lombok.Data;

/**
 *@ClassName SchoolMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/3 23:12
 *@Version 1.0
 */
@Data
public class School {
	private String id;
	private String schoolName;
	private String schoolCode;
	private String belongingDepartment;
	private String localAddress;
	private String level;
	private String simpleDesc;
	private String webSite;
	
}
