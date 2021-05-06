package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentContactInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName StudentContactInformationMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/4 20:10
 * @Version 1.0
 */
@Mapper
public interface StudentContactInformationMapper {
	/**
	 * private Long studentId;
	 * 	private String postAddress;
	 * 	private String postCode;
	 * 	private String telNumber;
	 * 	private String email;
	 * @return
	 */
	@Insert("insert into student_contact_information(student_id,post_address,post_code,tel_number,email)" +
			"values(#{studentId},#{postAddress},#{postCode},#{telNumber},#{email})")
	Integer save(StudentContactInformation studentContactInformation);
	
	@Select("select * from student_contact_information where student_id=#{studentId}")
	List<StudentContactInformation> findContactByStudentId(Integer studentId);
}
