package com.mams.mamsschool.entity;

import lombok.Data;

import java.util.Date;

/**
 *@ClassName ExamRequirement
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/7 10:10
 *@Version 1.0
 */
@Data
public class ExamRequirement {
	private int id;
	private int tutorId;
	private String schoolName;
	private String department;
	private String profession;
	private String politicalDemand;
	private String timeDemand;
	private String examDemand;
	private String publicCourseDemand;
	private String majorCourseDemand;
	private String extendMessage;
}
