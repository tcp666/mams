package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentExamApplication;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 *@ClassName StudentExamApplicationMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/4 20:44
 *@Version 1.0
 */
@Mapper
public interface StudentExamApplicationMapper {
	/**
	 * private Long studentId;
	 * 	private String signUpSchool;
	 * 	private String signUpMajor;
	 * 	private String signUpWay;
	 * 	private String specialPlan;
	 * 	//非定向就业，定向就业
	 * 	private String signUpType;
	 * 	private String targetedEmployCompany;
	 * 	private String targetedEmployCompanyAddress;
	 * 	private String signUpDepartment;
	 * 	private String signUpSchoolingType;
	 * 	private String researchDirection;
	 * 	private String majorCourses1;
	 * 	private String majorCourses2;
	 * 	private String majorCourses3;
	 * 	private String publicCourses1;
	 * 	private String publicCourses2;
	 * 	private String publicCourses3;
	 * 	private String extendMessage;
	 */
	
	@Insert("insert into student_exam_application(" +
			"student_id," +
			"sign_up_school," +
			"sign_up_major," +
			"sign_up_way," +
			"special_plan," +
			"sign_up_type," +
			"targeted_employ_company," +
			"targeted_employ_company_address," +
			"sign_up_department," +
			"sign_up_schooling_type," +
			"research_direction," +
			"major_courses1," +
			"major_courses2," +
			"major_courses3," +
			"public_courses1," +
			"public_courses2," +
			"public_courses3" +
			"extend_message)" +
			"values(" +
			"#{studentId}," +
			"#{signUpSchool}," +
			"#{signUpMajor}," +
			"#{signUpWay}," +
			"#{specialPlan}," +
			"#{signUpType}," +
			"#{targetedEmployCompany}," +
			"#{targetedEmployCompanyAddress}," +
			"#{signUpDepartment}," +
			"#{signUpSchoolingType}," +
			"#{researchDirection}," +
			"#{majorCourses1}," +
			"#{majorCourses2}," +
			"#{majorCourses3}," +
			"#{publicCourses1}," +
			"#{publicCourses2}," +
			"#{publicCourses3}" +
			"#{extendMessage}"+
			")")
	Integer save(StudentExamApplication studentExamApplication);
}
