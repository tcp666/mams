package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentCensusRegisterDocument;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName StudentCensusRegisterDocumentMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/4 20:02
 * @Version 1.0
 */

@Mapper
public interface StudentCensusRegisterDocumentMapper {
	
	@Insert("insert into student_census_register_document values(" +
			"#{studentId}," +
			"#{nativePlace}," +
			"#{birthAddress}," +
			"#{residenceAddress}," +
			"#{address}," +
			"#{documentAddress}," +
			"#{documentCompany}," +
			"#{documentCompanyAddress}," +
			"#{documentCompanyAddressPostCode})")
	Integer save(StudentCensusRegisterDocument document);
	
	@Select("select * from student_census_register_document where student_id=#{studentId}")
	List<StudentCensusRegisterDocument> findDocumentByStudentId(Integer studentId);
}
