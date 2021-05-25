package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.ExamResult;
import com.mams.mamsstudent.entity.StudentRealNameInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	@Select("select * from exam_result where tutor_id=#{tutorId} and receive_status=0 and exam_level=1 order by sum_score desc")
	List<ExamResult> findAllExamResultByTutorId(Integer tutorId);
	@Update("update exam_result set receive_status=#{receiveStatus} where student_id=#{studentId} and exam_level=#{examLevel}")
	Integer updataReceivpSatus(ExamResult examResult);
	
	@Select("select * from exam_result where tutor_id=#{tutorId} and receive_status=1 and exam_level=2 order by sum_score desc")
	List<ExamResult> findAllExamResultByTutorIdTwo(Integer tutorId);
	
	
}
