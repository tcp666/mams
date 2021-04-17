package com.mams.mamsstudent.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mams.mamscommon.utils.QiniuUpload;
import com.mams.mamscommon.utils.Verify;
import com.mams.mamsstudent.entity.*;
import com.mams.mamsstudent.mapper.StudentCensusRegisterDocumentMapper;
import com.mams.mamsstudent.mapper.StudentContactInformationMapper;
import com.mams.mamsstudent.mapper.StudentEducationBackgroundMapper;
import com.mams.mamsstudent.mapper.StudentRewardAndPunishmentMapper;
import com.mams.mamsstudent.service.StudentBaseInfoService;
import com.mams.mamsstudent.service.StudentRealNameInfoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.mams.mamscommon.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentUserController {
	@Autowired
	QiniuUpload qiniuUpload;
	@Autowired
	StudentRealNameInfoService studentRealNameInfoService;
	@Autowired
	StudentBaseInfoService studentBaseInfoService;
	@Resource
	StudentCensusRegisterDocumentMapper documentMapper;
	@Resource
	StudentEducationBackgroundMapper educationBackgroundMapper;
	@Resource
	StudentContactInformationMapper studentContactInformationMapper;
	@Resource
	StudentRewardAndPunishmentMapper studentRewardAndPunishmentMapper;
	
	@RequestMapping("/getAllUser")
	public Result<String> getAllUser() {
		return Result.success(studentRealNameInfoService.getAll());
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Result<StudentRealNameInfo> register(@RequestBody StudentRealNameInfo studentRealNameInfo) {
		System.out.println(studentRealNameInfo);
		if (studentRealNameInfo.getPassword() == "")
			return Result.fail("password 为空!");
		if (studentRealNameInfo.getUserName() == "")
			return Result.fail("username 为空!");
		if (studentRealNameInfo.getEmail() == "")
			return Result.fail("email 为空!");
		if (studentRealNameInfoService.register(studentRealNameInfo) > 0)
			return Result.success(studentRealNameInfo);
		return Result.fail(studentRealNameInfo);
	}
	
	@RequestMapping("/sendCheckCode")
	@ResponseBody
	public Result<String> sendCheckCode(@RequestBody StudentRealNameInfo info) throws MessagingException {
		return Result.success(Verify.sendMsg(info.getEmail(), Verify.getCheckCode()));
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Result<StudentRealNameInfo> login(@RequestBody StudentRealNameInfo info) {
		System.out.println(info);
		return Result.success(studentRealNameInfoService.login(info).get(0));
	}
	
	@RequestMapping("/saveStudentBaseInfo")
	@ResponseBody
	public Result<StudentBaseInfo> saveStudentBaseInfo(@RequestBody StudentBaseInfo baseInfo) {
		System.out.println(baseInfo);
		try {
			return Result.success(studentBaseInfoService.save(baseInfo));
		} catch (Exception e) {
			System.out.println("错误");
		}
		return Result.fail(0);
		
	}
	
	@RequestMapping("/saveStudentCensusRegisterDocument")
	@ResponseBody
	public Result<StudentBaseInfo> saveStudentCensusRegisterDocument(@RequestBody StudentCensusRegisterDocument document) {
		Integer count = 0;
		System.out.println(document);
		try {
			count = documentMapper.save(document);
			System.out.println(count);
			
			return Result.success(count);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误");
			
		}
		
		return Result.fail(count);
	}
	
	@RequestMapping("/saveEducationBackground")
	@ResponseBody
	public Result<Integer> saveEducationBackground(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		StudentEducationBackground background = null;
		Integer count = 0;
		try {
			System.out.println(request.getParameter("background"));
			String url = qiniuUpload.updateFile(file, UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.')));
			ObjectMapper objectMapper = new ObjectMapper();
			background = objectMapper.readValue(request.getParameter("background"), StudentEducationBackground.class);
			background.setStudentSrc(url);
			
			System.out.println(background);
			count = educationBackgroundMapper.save(background);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Result.success(count);
		
	}
	
	@RequestMapping("/saveContact")
	@ResponseBody
	public Result<Integer> saveContact(@RequestBody StudentContactInformation contactInformation) {
		try {
			return Result.success(studentContactInformationMapper.save(contactInformation));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success("0");
	}
	
	@RequestMapping("/savePAndR")
	@ResponseBody
	@Transactional
	public Result<Object> savePAndR(@RequestBody StudentRewardAndPunishment[] list) {
		int i;
		
		for (i = 0; i < list.length; i++) {
			studentRewardAndPunishmentMapper.add(list[i]);
		}
		
		return Result.success("success");
	}
	
}
