package com.mams.mamscommon.mapper;

import com.mams.mamscommon.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@ClassName UserMapper
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/5/6 17:04
 *@Version 1.0
 */
@Mapper
public interface UserMapper {
	
	@Insert("insert into user values(#{userId},#{userName},#{password},#{idNumber},#{email})")
	Integer save(User user);
	
	
	@Select("select * from user where user_id=#{userId}")
	List<User> findByUserId(Integer userId);
	
	
	@Select("select * from user where password=#{password} and email=#{email}")
	List<User> login(User user);
	
}
