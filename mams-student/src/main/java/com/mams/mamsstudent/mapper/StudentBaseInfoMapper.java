package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
			"#{nation}," +
			"#{gender}," +
			"#{servicemen}," +
			"#{politicalOutlook}" +
			")")
	Integer save(StudentBaseInfo info);
	
}
