package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName ExamApplication
 * @Description 志愿信息
 * @Author TangCaiping
 * @Date 2021/2/3 12:17
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ExamApplication {
	//志愿编号
	private int no;
	//志愿等级
	private int level;
	//考生编号
	private Long studentNo;
	//学校名称
	private String schoolName;
	//院系名称
	private String departmentName;
	//专业名称
	private String professionName;
	//调剂意愿
	private int regulate;
	//调剂状态
	private int regulateStatus;
}
