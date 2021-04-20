package com.mams.mamscommon.service;

import com.mams.mamscommon.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @InterfaceName SchoolService
 * @Description TODO
 * @Author Haining
 * @Date 2021/4/4 12:56
 * @Version 1.0
 */
@Service
public interface SchoolService {
	Integer add(School school);
	
	List<School> findByName(String schoolName);
}
