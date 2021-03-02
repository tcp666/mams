package com.mams.mamsstudent.entity;

import lombok.*;

/**
 *@ClassName StudentCensusRegisterDocument
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/3 17:38
 *@Version 1.0
 */

@Data
public class StudentCensusRegisterDocument {
	private Long studentId;
	//籍贯
	private String nativePlace;
	//出生地
	private String birthAddress;
	//户口所在地
	private String residenceAddress;
	private String address;
	private String documentAddress;
	private String documentCompany;
	private String documentCompanyAddress;
	private String documentCompanyAddressPostCode;
}
