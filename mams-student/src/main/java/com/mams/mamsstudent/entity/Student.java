package com.mams.mamsstudent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@ClassName Student
 *@Description 考生信息
 *@Author  TangCaiping
 *@Date 2021/2/2 20:16
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Student {
	private Long studentNo;
	private String studentName;
	private String studentInfoNo;
	private String admissionTicketNo;
	private String schoolName;
	private String departmentName;
	private String professionName;
}
