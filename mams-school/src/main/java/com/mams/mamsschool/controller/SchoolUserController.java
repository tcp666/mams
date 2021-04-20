package com.mams.mamsschool.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mams.mamscommon.utils.QiniuUpload;
import com.mams.mamscommon.utils.Result;
import com.mams.mamscommon.utils.Verify;
import com.mams.mamsschool.entity.EnrollmentProject;
import com.mams.mamsschool.entity.ExamRequirement;
import com.mams.mamsschool.entity.Tutor;

import com.mams.mamsschool.mapper.EnrollmentProjectMapper;
import com.mams.mamsschool.mapper.ExamRequirementMapper;
import com.mams.mamsschool.service.TutorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/2/7 17:26
 * @Version 1.0
 */

@RestController
@RequestMapping("/school")
class SchoolUserController {
	@Autowired
	TutorService tutorService;
	
	@Autowired
	QiniuUpload qiniuUpload;
	@Resource
	ExamRequirementMapper examRequirementMapper;
	@Resource
	EnrollmentProjectMapper enrollmentProjectMapper;
	
	@RequestMapping("/login")
	@ResponseBody
	public Result<Tutor> login(@RequestBody Tutor tutor) {
		
		System.out.println(tutor);
		List<Tutor> tutors = tutorService.find(tutor);
		if (tutors.size() != 1) {
			return Result.fail(tutor);
			
		}
		tutor = tutors.get(0);
		System.out.println("database" + tutor);
		tutor.setPassword("");
		System.out.println(tutor + "password");
		return Result.success(tutor);
	}
	
	@RequestMapping("/signup")
	@ResponseBody
	public Result<Tutor> signUp(@RequestBody Tutor tutor) {
		
		System.out.println(tutor);
		Integer add = tutorService.add(tutor);
		if (add != 1) {
			return Result.fail(tutor);
		}
		
		List<Tutor> tutors = tutorService.find(tutor);
		if (tutors.size() != 1)
			return Result.fail(tutor);
		else {
			tutor = tutors.get(0);
			tutor.setPassword("");
			System.out.println(tutor + "**************************************");
			return Result.success(tutor);
		}
		
		
	}
	
	@RequestMapping("/getCheckCode")
	@ResponseBody
	public Result<String> sendCheckCode(@RequestBody Tutor tutor) {
		System.out.println(tutor.getEmail());
		String checkCode = Verify.getCheckCode();
		try {
			return Result.success(Verify.sendMsg(tutor.getEmail(), checkCode));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return Result.fail(null);
	}
	
	@RequestMapping(value = "/saveTutor")
	@ResponseBody
	public Result<Tutor> saveTutor(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Tutor tutor = null;
		try {
			System.out.println(request.getParameter("tutor"));
			String url = qiniuUpload.updateFile(file, UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.')));
			ObjectMapper objectMapper = new ObjectMapper();
			tutor = objectMapper.readValue(request.getParameter("tutor"), Tutor.class);
			tutor.setImgSrc(url);
			
			System.out.println(tutor);
			System.out.println(tutorService.update(tutor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return Result.success(tutor);
	}
	
	@RequestMapping("/saveExamRequire")
	@ResponseBody
	public Result<Integer> saveExamRequire(@RequestBody ExamRequirement examRequirement) {
		System.out.println(examRequirement);
		return Result.success(examRequirementMapper.save(examRequirement));
	}
	
	@RequestMapping("/saveEnrollmentProject")
	@ResponseBody
	public Result<Integer> saveEnrollmentProject(@RequestBody EnrollmentProject project) {
		System.out.println(project);
		return Result.success(enrollmentProjectMapper.save(project));
		
	}
}
