package com.mams.mamsstudent.entity;

import lombok.*;

/**
 *@ClassName StudentBaseInfo
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:28
 *@Version 1.0
 */

@Data
public class StudentBaseInfo {
	private Long no;
	private Long studentId;
	private String nation;
	private String gender;
	//婚否
	private String marriage;
	//现役军人
	private String servicemen;
	//政治面貌
	private String politicalOutlook;
}
