package com.mams.mamsstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@ClassName StudentContactInformation
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:55
 *@Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentContactInformation {
	private Long studentId;
	private String postAddress;
	private String postCode;
	private String telNumber;
	private String email;
}
