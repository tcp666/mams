package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.ExamResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName ExamResultMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/5/5 16:19
 * @Version 1.0
 */

@Mapper
public interface ExamResultMapper {
	
	@Select("select * from exam_result where tutor_id=#{tutorId};")
	List<ExamResult> findAllExamResultByTutorId(Integer tutorId);
}
