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
@Mapper
public interface StudentRealNameInfoMapper {
	@Select("select * from student_real_name_info")
	List<StudentRealNameInfo> getAllUser();
	
	@Insert("insert into student_real_name_info(user_name,email,password) values(#{userName},#{email},#{password})")
	Integer register(StudentRealNameInfo studentRealNameInfo);
	
	@Select("select * from student_real_name_info where password=#{password} and email=#{email}")
	List<StudentRealNameInfo> login(StudentRealNameInfo info);
	
	
	@Update("update student_real_name_info student_name=#{studentName} ,id_type=#{idType},id_number=#{idNumber},tel_number=#{telNumber} where email=email")
	Integer update(StudentRealNameInfo info);
}
