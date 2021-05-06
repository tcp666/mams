package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.ExamMessageInfo;
import com.mams.mamsstudent.entity.StudentApplication;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ExamMessageInfoMapper
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/5/4 20:45
 * @Version 1.0
 */

/**
 * public class ExamMessageInfo {
 * 	private Long examNo;
 * 	private Long studentId;
 * 	private String address;
 * 	private int roomNo;
 * 	private int seatNumber;
 * 	private String courseName;
 * 	private String courseCode;
 * 	private String examType;
 * 	private String paperType;
 * 	private Date startTime;
 * 	private Date endTime;
 *
 * }
 */
@Mapper
public interface ExamMessageInfoMapper {
	
	@Insert("insert into exam_message_info values (" +
			"#{examNo}," +
			"#{studentId}," +
			"#{address}," +
			"#{roomNo}," +
			"#{seateNumber}," +
			"#{courseName}," +
			"#{courseCode}," +
			"#{examType}," +
			"#{paperType}," +
			"#{startTime}," +
			"#{endTime}" +
			")")
	Integer add(ExamMessageInfo messageInfo);
	@Select("select * from exam_message_info where student_id=#{studentId}")
	List<ExamMessageInfo> findExamByStudentId(Integer studentId);
	
	
	
}
