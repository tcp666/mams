package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@ClassName StudentStudyAndWorkExperience
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:48
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentStudyAndWorkExperience {
	private Long studentId;
	private String company;
	private String workerExperienceMessage;
	private String school;
	private String studyExperienceMessage;
}
