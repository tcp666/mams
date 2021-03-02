package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName StudentEducationBackground
 * @Description 学籍学历
 * @Author TangCaiping
 * @Date 2021/2/3 17:10
 * @Version 1.0
 */
@Data
public class StudentEducationBackground {
	private Long studentId;
	private String studentSrc;
	private String graduateSchool;
	private String graduateProfession;
	//学制
	private String lastGraduateSchoolingType;
	//最终学历
	private String lastEducation;
	//学历证书编号
	private String lastEducationNo;
	private Date graduatedTime;
	//学号
	private String studentNo;
	
	private String certificateNumber;
}
