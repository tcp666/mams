package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentStudyAndWorkExperience;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName StudentStudyAndWorkExperienceMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/4/19 16:10
 * @Version 1.0
 */

@Mapper
public interface StudentStudyAndWorkExperienceMapper {

	@Insert("insert into student_study_and_work_experience values(#{studentId},#{company},#{workerExperienceMessage},#{school},#{studyExperienceMessage})")
	Integer add(StudentStudyAndWorkExperience experience);
}
