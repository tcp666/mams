package com.mams.mamsstudent.entity;

import lombok.*;

/**
 * @ClassName StudentExamApplication
 * @Description 志愿信息
 * @Author TangCaiping
 * @Date 2021/2/3 12:17
 * @Version 1.0
 */

@Data
public class StudentExamApplication {
	private Long studentId;
	private String signUpSchool;
	private String signUpMajor;
	private String signUpWay;
	private String specialPlan;
	//非定向就业，定向就业
	private String signUpType;
	private String targetedEmployCompany;
	private String targetedEmployCompanyAddress;
	private String signUpDepartment;
	private String signUpSchoolingType;
	private String researchDirection;
	private String majorCourses1;
	private String majorCourses2;
	private String majorCourses3;
	private String publicCourses1;
	private String publicCourses2;
	private String publicCourses3;
	private String extendMessage;
}
