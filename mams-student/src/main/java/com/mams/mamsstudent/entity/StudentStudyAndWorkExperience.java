package com.mams.mamsstudent.entity;

import lombok.Data;

/**
 *@ClassName StudentStudyAndWorkExperience
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:48
 *@Version 1.0
 */

@Data
public class StudentStudyAndWorkExperience {
	private Long studentId;
	private String company;
	private String workerExperienceMessage;
	private String school;
	private String studyExperienceMessage;
}
