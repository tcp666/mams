package com.mams.mamsstudent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@ClassName StudentRealNameInfo
 *@Description 基本信息
 *@Author  TangCaiping
 *@Date 2021/2/2 20:16
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentRealNameInfo {
	private Long studentId;
	private String studentName;
	private String idType;
	private String idNumber;
	private String telNumber;
	
}
