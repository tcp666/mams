package com.mams.mamsstudent.service;

import com.mams.mamsstudent.entity.ExamMessageInfo;

/**
 * @InterfaceName ExamMessageInfoService
 * @Description TODO
 * @Author Haining
 * @Date 2021/5/4 20:52
 * @Version 1.0
 */

public interface ExamMessageInfoService {
	
	Integer add(ExamMessageInfo messageInfo);

	ExamMessageInfo findExamByStudentId(Integer studentId);
}
