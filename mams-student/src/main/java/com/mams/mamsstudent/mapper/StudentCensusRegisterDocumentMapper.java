package com.mams.mamsstudent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName StudentCensusRegisterDocumentMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/3/4 20:02
 * @Version 1.0
 */

@Mapper
public interface StudentCensusRegisterDocumentMapper {
	/**
	 * private Long studentId;
	 * 	//籍贯
	 * 	private String nativePlace;
	 * 	//出生地
	 * 	private String birthAddress;
	 * 	//户口所在地
	 * 	private String residenceAddress;
	 * 	private String address;
	 * 	private String documentAddress;
	 * 	private String documentCompany;
	 * 	private String documentCompanyAddress;
	 * 	private String documentCompanyAddressPostCode;
	 * 	*************************
	 * 	  `student_id` bigint(20) NOT NULL,
	 *   `native_place` varchar(50) DEFAULT NULL,
	 *   `birth_address` varchar(80) DEFAULT NULL,
	 *   `residence_address` varchar(40) DEFAULT NULL,
	 *   `address` varchar(80) DEFAULT NULL,
	 *   `document_address` varchar(80) DEFAULT NULL,
	 *   `document_company` varchar(80) DEFAULT NULL,
	 *   `document_company_address` varchar(80) DEFAULT NULL,
	 *   `document_company_address_post_code` varchar(10) DEFAULT NULL,
	 *   KEY `student_id` (`student_id`),
	 * }
	 */
	@Insert("insert into student_census_register_document" +
			"(student_id,native_place,birth_address,residence_address,address,document_address,document_company,document_company_address,document_company_address_post_code)" +
			"values(#{studentId},#{nativePlace},#{birthAddress},#{residenceAddress},#{address},#{documentAddress},#{documentCompanyAddress},#{documentCompanyAddressPostCode})")
	Integer save();
}
