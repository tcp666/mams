package com.mams.mamsschool.entity;

import java.util.Date;

/**
 *@ClassName ExamRequirement
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/2/7 10:10
 *@Version 1.0
 */
public class ExamRequirement {
	private int id;
	private String schoolName;
	private String department;
	private String profession;
	private String politicalDemand;
	private String timeDemand;
	private String examDemand;
	private String publicCourseDemand;
	private String extendMessage="1、考研由国家考试主管部门和招" +
			"生单位组织的初试和复试组成。思想政治理论、外国语、大学数" +
			"学等公共科目由全国统一命题，专业课主要由各招生单位自行命题。\n" +
			"\n" +
			"2、考研国家线划定分为A、B类，其中一区实行A类线，二区实行" +
			"B类线。一区包括：北京、天津、河北、山西、辽宁、吉林、黑龙江" +
			"、上海、江苏、浙江、安徽、福建、江西、山东、河南、湖北、湖南、广东、重庆、四川、陕西。\n" +
			"\n" +
			"二区包括：内蒙古、广西、海南" +
			"、贵州、云南、西藏、甘肃、" +
			"青海、宁夏、新疆。\n" +
			"\n" +
			"3、考研考试成绩公布时间为每" +
			"年3月份，复试一般在3-5月。" +
			"复试分为笔试和面试，笔试分为英语" +
			"的听力笔试和专业笔试，面试分为英语口" +
			"语和专业课面试。";
}
