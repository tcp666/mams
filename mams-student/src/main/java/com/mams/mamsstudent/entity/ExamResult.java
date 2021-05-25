package com.mams.mamsstudent.entity;


import lombok.Data;

/**
 *@ClassName ExamResult
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/5/5 14:57
 *@Version 1.0
 */
@Data
public class ExamResult {
	private Integer id;
	private Integer studentId;
	private Integer tutorId;
	private Integer projectId;
	private String 	examLevel;
	private String 	sumScore;
	private Integer publicCourse1;
	private Integer publicCourse2;
	private Integer publicCourse3;
	private Integer majorCourse1;
	private Integer majorCourse2;
	private Integer majorCourse3;
	
	private String schoolName;
	private String professionName;
	
	private int receiveStatus;
	
	
}
