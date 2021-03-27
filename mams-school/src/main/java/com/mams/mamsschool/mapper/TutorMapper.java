package com.mams.mamsschool.mapper;

import com.mams.mamscommon.utils.Result;
import com.mams.mamsschool.entity.Tutor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@ClassName TutorMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/11 19:40
 *@Version 1.0
 */

/**
 *private int tutorId;
 * 	private String realName;
 * 	private String schoolName;
 * 	private String department;
 * 	private String profession;
 * 	private String ID_CODE;
 * 	private String email;
 * 	private String imgSrc;
 * 	private String userName;
 * 	private String password;
 * 	private int checked;
 */
@Mapper
public interface TutorMapper {
	@Insert("insert into tutor values(" +
			"#{tutorId}," +
			"#{realName}," +
			"#{schoolName}," +
			"#{department}," +
			"#{profession}," +
			"#{ID_CODE}," +
			"#{email}," +
			"#{imgSrc}," +
			"#{userName}," +
			
			"#{password}," +
			"#{checked}) ")
	Integer save(Tutor tutor);
	
	
	@Select("select * from tutor where real_name =#{realName} and password=#{password}")
	List<Tutor> findByTutor(Tutor tutor);
}
