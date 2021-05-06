package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentRealNameInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName StudentRealNameInfoMapper
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:41
 * @Version 1.0
 */

/**
 * 	private Long studentId;
 * 	private String studentName;
 * 	private String userName;
 * 	private String password;
 * 	private String idType;
 * 	private String idNumber;
 * 	private String telNumber;
 * 	private String email;
 * 	private Integer checked;
 */
@Mapper
public interface StudentRealNameInfoMapper {
	@Select("select * from student_real_name_info")
	List<StudentRealNameInfo> getAllUser();
	
	@Insert("insert into student_real_name_info values(" +
			"#{studentId}," +
			"#{studentName}," +
			"#{userName}," +
			"#{password}," +
			"#{idType}," +
			"#{idNumber}," +
			"#{telNumber}," +
			"#{email}," +
			"#{checked}" +
			")")
	Integer register(StudentRealNameInfo studentRealNameInfo);
	
	@Select("select * from student_real_name_info where password=#{password} and email=#{email}")
	List<StudentRealNameInfo> login(StudentRealNameInfo info);
	
	
	@Update("update student_real_name_info student_name=#{studentName} ,id_type=#{idType},id_number=#{idNumber},tel_number=#{telNumber} where email=email")
	Integer update(StudentRealNameInfo info);
	
	@Select("select * from student_real_name_info where student_id=#{studentId};")
	List<StudentRealNameInfo>  getStudentRealNameInfoByStudentId(Integer studentId);
	
	
	@Update("update student_real_name_info set checked=#{checked}  where student_id=#{studentId}")
	Integer updateChecked(StudentRealNameInfo info);
}
