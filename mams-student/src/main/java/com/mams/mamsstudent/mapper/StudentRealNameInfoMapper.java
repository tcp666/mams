package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentRealNameInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
