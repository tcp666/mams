package com.mams.mamsschool.service;

import com.mams.mamsschool.entity.Tutor;

import java.util.List;

/**
 *@ClassName TutorService
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/15 19:30
 *@Version 1.0
 */
public interface TutorService {
	Integer add(Tutor tutor);
	List<Tutor> find(Tutor tutor);
}
