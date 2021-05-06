package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentBaseInfo;
import com.mams.mamsstudent.entity.StudentRealNameInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName StudentBaseInfoMapper
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/4 19:47
 * @Version 1.0
 */
@Mapper
public interface StudentBaseInfoMapper {
	/**
	 * private Long no;
	 * private Long studentId;
	 * private String nation;
	 * private String gender;
	 * //婚否
	 * private int gender;
	 * //现役军人
	 * private int servicemen;
	 * //政治面貌
	 * private String politicalOutlook;
	 * }
	 */
	
	
	@Insert("insert into student_base_info(" +
			"student_id," +
			"nation," +
			"gender," +
			"marriage," +
			"servicemen," +
			"political_out_look) " +
			"values(" +
			"#{studentId}," +
			"#{nation}," +
			"#{gender}," +
			"#{marriage}," +
			"#{servicemen}," +
			"#{politicalOutlook}" +
			")")
	Integer save(StudentBaseInfo info);
	
	@Select("select * from student_base_info where student_id=#{studentId}")
	List<StudentBaseInfo> findByStudentId(StudentRealNameInfo info);
	
}
