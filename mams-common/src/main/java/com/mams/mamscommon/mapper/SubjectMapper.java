package com.mams.mamscommon.mapper;

import com.mams.mamscommon.entity.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@ClassName SubjectMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/11 20:27
 *@Version 1.0
 */

/**
 * private int coursesId;
 * 	//学科门类
 * 	private String category;
 * 	//	专业类型1，学术型，2，专业型
 * 	private String majorType;
 * 	private String courseName;
 * 	private String courseCode;
 */
@Mapper
public interface SubjectMapper {
	@Insert("insert into subject values(#{subjectId},#{category},#{majorType},#{subjectName},#{subjectCode},#{deptName},#{deptCode})")
	void save(Subject subject);
	
	@Select("select dept_name from subject group by dept_name;")
	List<String> getAllDeptName();
	@Select("select subject_name from subject group by subject_name;")
	List<String> getAllSubjectName();
}
