package com.mams.mamscommon.mapper;


import com.mams.mamscommon.entity.School;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName SchoolMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/3 23:51
 * @Version 1.0
 */

@Mapper
public interface SchoolMapper {

//	private String id;
//	private String schoolName;
//	private String schoolCode;
//	private String belongingDepartment;
//	private String localAddress;
//	private String level;
@Insert("insert into school values (#{id},#{schoolName},#{schoolCode},#{belongingDepartment},#{localAddress},#{level})")
	 void insert(School school);
}
