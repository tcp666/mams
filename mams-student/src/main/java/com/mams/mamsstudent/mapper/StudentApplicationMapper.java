package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentApplication;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@ClassName StudentApplicationMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/5/2 18:09
 *@Version 1.0
 */
@Mapper
public interface StudentApplicationMapper {
	@Insert("insert into student_application values(#{id},#{studentId},#{projectId},#{requirementId},#{tutorId});")
	Integer save(StudentApplication application);
	
	
	@Select("select * from student_application where studentId=#{studentId};")
	List<StudentApplication> findStudentApplicationByStudentId(Integer studentId);
	
	
	@Select("select * from student_application where studentId=#{tutorId};")
	List<StudentApplication> findStudentApplicationByTutorId(Integer tutorId);
}
