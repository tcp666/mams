package com.mams.mamsschool.mapper;

import com.mams.mamsschool.entity.EnrollmentProject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName EnrollmentProjectMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/11 19:45
 * @Version 1.0
 */

/**
 * private int id;
 * private String tutorName;
 * private String schoolName;
 * private String department;
 * private String professionName;
 * private int count;
 * private String examType;
 * private String schoolingType;
 * private String education;
 * private String contactNumber;
 * private String majorCourses1;
 * private String majorCourses2;
 * private String majorCourses3;
 * private String publicCourses1;
 * private String publicCourses2;
 * private String publicCourses3;
 */
@Mapper
public interface EnrollmentProjectMapper {
	@Insert("insert into enrollment_project values(" +
			"#{id}," +
			"#{tutorName}," +
			"#{tutorId}," +
			"#{schoolName}," +
			"#{department}," +
			"#{professionName}," +
			"#{count}," +
			"#{examType}," +
			"#{schoolingType}," +
			"#{education}," +
			"#{contactNumber}," +
			"#{signUpType}," +
			"#{majorCourses1}," +
			"#{majorCourses2}," +
			"#{majorCourses3}," +
			"#{publicCourses1}," +
			"#{publicCourses2}," +
			"#{publicCourses3}" +
			");")
	Integer save(EnrollmentProject project);
	
	
	@Select("select * from enrollment_project order by school_name;")
	List<EnrollmentProject> findAll();
}
