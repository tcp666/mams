package com.mams.mamsschool.service.imp;

import com.mams.mamsschool.entity.Tutor;
import com.mams.mamsschool.mapper.TutorMapper;
import com.mams.mamsschool.service.TutorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName TutorServiceImp
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/15 19:32
 *@Version 1.0
 */
@Service
public class TutorServiceImp implements TutorService {
	@Resource
	TutorMapper tutorMapper;
	@Override
	public Integer add(Tutor tutor) {
		return tutorMapper.save(tutor);
	}
	
	@Override
	public List<Tutor> find(Tutor tutor) {
		return tutorMapper.findByTutor(tutor);
	}
}
