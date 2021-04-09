package com.mams.mamsschool.mapper;

import com.mams.mamscommon.utils.Result;
import com.mams.mamsschool.entity.Tutor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName TutorMapper
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/11 19:40
 * @Version 1.0
 */

/**
 *private int tutorId;
 * 	private String realName;
 * 	private String schoolName;
 * 	private String department;
 * 	private String profession;
 * 	private String idCode;
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
			"#{idCode}," +
			"#{email}," +
			"#{imgSrc}," +
			"#{userName}," +
			"#{password}," +
			"#{checked}) ")
	Integer save(Tutor tutor);
	
	@Update("update tutor set " +
			"school_name=#{schoolName}," +
			"department=#{department}," +
			"profession=#{profession}," +
			"id_code=#{idCode}," +
			"img_src=#{imgSrc} where tutor_id=#{tutorId}")
	Integer update(Tutor tutor);
	
	@Select("select * from tutor where email =#{email} and password=#{password}")
	List<Tutor> findByTutor(Tutor tutor);
	
	
}
