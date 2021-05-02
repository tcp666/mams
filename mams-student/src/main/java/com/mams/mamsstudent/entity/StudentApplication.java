package com.mams.mamsstudent.entity;

import lombok.Data;

/**
 *@ClassName StudentApplication
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/5/2 18:07
 *@Version 1.0
 */
@Data
public class StudentApplication {
	private Integer id;
	private Integer studentId;
	private Integer projectId;
	private Integer requirementId;
	private Integer tutorId;
}
