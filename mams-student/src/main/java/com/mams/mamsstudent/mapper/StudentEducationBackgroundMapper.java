package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentEducationBackground;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName StudentEducationBackgroundMapper
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/4 20:24
 * @Version 1.0
 */
@Mapper
public interface StudentEducationBackgroundMapper {
	/**
	 * private Long studentId;
	 * private String studentSrc;
	 * private String graduateSchool;
	 * private String graduateProfession;
	 * //学制
	 * private String lastGraduateSchoolingType;
	 * //最终学历
	 * private String lastEducation;
	 * //学历证书编号
	 * private String lastEducationNo;
	 * private Date graduatedTime;
	 * //学号
	 * private String studentNo;
	 * <p>
	 * private String certificateNumber;
	 *
	 * @return
	 */
	@Insert("insert into student_education_background values(" +
			"#{studentId}," +
			"#{studentSrc}," +
			"#{graduateSchool}," +
			"#{graduateProfession}," +
			"#{lastGraduateSchoolingType}," +
			"#{lastEducation}," +
			"#{lastEducationNo}," +
			"#{graduatedTime}," +
			"#{studentNo}," +
			"#{certificateNumber}" +
			")")
	Integer save(StudentEducationBackground background);
	
	@Select("select * from student_education_background where student_id=#{studentId}")
	List<StudentEducationBackground> findByStudentId(Long studentId);
	
	
	
}
