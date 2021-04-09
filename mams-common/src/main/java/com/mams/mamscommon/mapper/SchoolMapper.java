package com.mams.mamscommon.mapper;


import com.mams.mamscommon.entity.School;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName SchoolMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/3 23:51
 * @Version 1.0
 */

@Mapper
public interface SchoolMapper {
	
	@Insert("insert into school values (#{id},#{schoolName},#{schoolCode},#{belongingDepartment},#{localAddress},#{level},#{simpleDesc},#{webSite})")
	void insert(School school);
	
	
	@Select("select * from school where school_name=#{schoolName}")
	List<School> findByName(String schoolName);
	
	@Select("select * from school")
	List<School> getAllSchool();
	
	
	
}
