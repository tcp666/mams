package com.mams.mamsschool.mapper;

import com.mams.mamsschool.entity.EnrollmentProject;
import com.mams.mamsschool.entity.ExamRequirement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@ClassName ExamRequirementMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/11 19:29
 *@Version 1.0
 */

/**
 *private int id;
 * 	private String schoolName;
 * 	private String department;
 * 	private String profession;
 * 	private String politicalDemand;
 * 	private String timeDemand;
 * 	private String examDemand;
 * 	private String publicCourseDemand;
 * 	private String extendMessage
 */
@Mapper
public interface ExamRequirementMapper {
	@Insert("insert into exam_requirement " +
			"values(" +
			"#{id},"+
			"#{tutorId},"+
			"#{schoolName}," +
			"#{department}," +
			"#{profession}," +
			"#{politicalDemand}," +
			"#{timeDemand}," +
			"#{examDemand}," +
			"#{publicCourseDemand}," +
			"#{majorCourseDemand},"+
			"#{extendMessage});")
	Integer  save(ExamRequirement requirement);
	@Select("select * from exam_requirement where tutor_id=#{tutorId} and department=#{department} and profession=#{professionName} ")
	List<ExamRequirement> findExamRequirementByEnrollmentProject(EnrollmentProject enrollmentProject);
	
}
