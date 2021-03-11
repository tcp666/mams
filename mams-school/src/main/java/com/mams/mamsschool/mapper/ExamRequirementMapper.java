package com.mams.mamsschool.mapper;

import com.mams.mamsschool.entity.ExamRequirement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
	@Insert("insert into exam_requirement(school_name," +
			"department," +
			"profession," +
			"political_demand," +
			"time_demand," +
			"exam_demand," +
			"public_course_demand)," +
			"values(" +
			"#{schoolName}," +
			"#{department}," +
			"#{profession}," +
			"#{politicalDemand}," +
			"#{timeDemand}," +
			"#{examDemand}," +
			"#{publicCourseDemand}," +
			"#{extendMessage})")
	void  save(ExamRequirement requirement);
}
