package com.mams.mamscommon.entity;

import lombok.Data;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/11 20:15
 * @Version 1.0
 */
@Data
public class Subject {
	private int subjectId;
	
	//学科门类
	private String category;
	//	专业类型1，学术型，2，专业型
	private String majorType;
	private String subjectName;
	private String subjectCode;
	
	private String deptName;
	private String deptCode;
	
}
