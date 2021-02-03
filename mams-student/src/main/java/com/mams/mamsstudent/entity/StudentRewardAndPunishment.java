package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@ClassName StudentRewardAndPunishment
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:52
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentRewardAndPunishment {
	private Long studentId;
	private String rewardMessage;
	private String Punishment;
	
}
