package com.mams.mamsstudent.service.impl;

import com.mams.mamsstudent.entity.ExamMessageInfo;
import com.mams.mamsstudent.entity.StudentApplication;
import com.mams.mamsstudent.entity.StudentEducationBackground;
import com.mams.mamsstudent.mapper.ExamMessageInfoMapper;
import com.mams.mamsstudent.mapper.StudentApplicationMapper;
import com.mams.mamsstudent.mapper.StudentEducationBackgroundMapper;
import com.mams.mamsstudent.service.ExamMessageInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName ExamMessageInfoServiceImpl
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/5/4 20:54
 *@Version 1.0
 */
@Service
public class ExamMessageInfoServiceImpl implements ExamMessageInfoService {
	@Resource
	ExamMessageInfoMapper examMessageInfoMapper;
	@Resource
	StudentApplicationMapper studentApplicationMapper;
	@Resource
	StudentEducationBackgroundMapper studentEducationBackgroundMapper;
	
	
	@Override
	public Integer add(ExamMessageInfo messageInfo) {
		List<StudentApplication> studentApplicationList = studentApplicationMapper.findAll();
		for (StudentApplication application : studentApplicationList) {
			StudentEducationBackground background=studentEducationBackgroundMapper.findByStudentId(application.getStudentId()).get(0);
		}
	
		
		
		
		return examMessageInfoMapper.add(messageInfo);
	}
	
	@Override
	public ExamMessageInfo findExamByStudentId(Integer studentId) {
		return examMessageInfoMapper.findExamByStudentId(studentId).get(0);
	}
}
