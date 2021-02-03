package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 *@ClassName ExamMessageInfo
 *@Description 考试信息
 *@Author  TangCaiping
 *@Date 2021/2/3 13:45
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ExamMessageInfo {
	private Long no;
	private Long studentId;
	private String address;
	private int roomNo;
	private int seatNumber;
	private String courseName;
	private String courseCode;
	private String examType;
	private Date startTime;
	private Date endTime;
	
}
