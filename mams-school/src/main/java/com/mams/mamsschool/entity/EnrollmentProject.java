package com.mams.mamsschool.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

/**
 * @ClassName EnrollmentProject
 * @Description 招生计划
 * @Author TangCaiping
 * @Date 2021/2/7 10:17
 * @Version 1.0
 */
@Data
public class EnrollmentProject {
	private int id;
	//导师姓名
	private String tutorName;
	//导师id
	private String tutorId;
	//学校
	private String schoolName;
	//院系
	
	private String department;
	//专
	
	private String professionName;
	//招生人数
	
	private int count;
	//考试类型
	private String examType;
	//学制
	@NonNull
	private String schoolingType;
	//学历
	@NonNull
	private String education;
	//联系电话
	@NonNull
	private String contactNumber;
	//是否定向就业
	@NonNull
	private String signUpType;
	//专业课
	private String majorCourses1;
	private String majorCourses2;
	private String majorCourses3;
	//基础课
	private String publicCourses1;
	private String publicCourses2;
	private String publicCourses3;
	
	
	private int checked=0;
	
}
