package com.mams.mamsstudent.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mams.mamscommon.utils.QiniuUpload;
import com.mams.mamscommon.utils.Verify;
import com.mams.mamsstudent.entity.*;
import com.mams.mamsstudent.mapper.*;
import com.mams.mamsstudent.service.StudentBaseInfoService;
import com.mams.mamsstudent.service.StudentRealNameInfoService;



import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.mams.mamscommon.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import java.util.*;
import java.util.List;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/3/2 12:51
 * @Version 1.0
 */
@Log4j2
@RestController
@RequestMapping("/student")
@CrossOrigin
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
	@Resource
	StudentStudyAndWorkExperienceMapper studentStudyAndWorkExperienceMapper;
	@Resource
	StudentApplicationMapper studentApplicationMapper;
	@Resource
	ExamMessageInfoMapper examMessageInfoMapper;
	@Resource
	StudentEducationBackgroundMapper studentEducationBackgroundMapper;
	
	@Resource
	ExamResultMapper examResultMapper;
	
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
		System.out.println(studentRealNameInfoService.login(info));
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
	public Result<Object> savePAndR(@RequestBody StudentRewardAndPunishment[] list) {
		int i;
		
		for (i = 0; i < list.length; i++) {
			studentRewardAndPunishmentMapper.add(list[i]);
		}
		
		return Result.success("success");
	}
	
	@RequestMapping("/saveWandS")
	@ResponseBody
	public Result<Object> saveWandS(@RequestBody StudentStudyAndWorkExperience[] list) {
//		System.out.println("fsdfs");
		for (int i = 0; i < list.length; i++) {
			studentStudyAndWorkExperienceMapper.add(list[i]);
		}
		
		return Result.success("success");
	}
	
	@RequestMapping("/saveApplication")
	@ResponseBody
	@Transactional
	public Result<Integer> saveApplication(@RequestBody StudentApplication studentApplication) {
		System.out.println(studentApplication);
		Integer sum = studentApplicationMapper.countAllBySchoolAndProfession(studentApplication);
		ExamMessageInfo examMessageInfo = new ExamMessageInfo();
		examMessageInfo.setRoomNo((sum + 1) / 50 + 1);
		examMessageInfo.setSeateNumber((sum) % 50 + 1);
		examMessageInfo.setStudentId(studentApplication.getStudentId());
		examMessageInfo.setAddress(studentApplication.getProjectProfessionName());
		examMessageInfoMapper.add(examMessageInfo);
		return Result.success(studentApplicationMapper.save(studentApplication));
	}
	
	@RequestMapping("/getAllStudentInfos")
	@ResponseBody
	public Result<Map<String, Object>> getAllStudentInfos(@RequestBody StudentRealNameInfo info) {
		System.out.println(info);
		StudentBaseInfo studentBaseInfo = studentBaseInfoService.findByStudentId(info).get(0);
		Map<String, Object> allStudentInfos = new HashMap<>();
		allStudentInfos.put("studentBaseInfo", studentBaseInfo);
		
		StudentEducationBackground background = studentEducationBackgroundMapper.findByStudentId(info.getStudentId()).get(0);
		allStudentInfos.put("studentRealNameInfo", info);
		allStudentInfos.put("background", background);
		return Result.success(allStudentInfos);
	}
	
	@RequestMapping("/getExamInfoByStudentId")
	@ResponseBody
	public Result<ExamMessageInfo> getExamInfoByStudentId(@RequestBody Map<String, Integer> map) {
		Integer integer = map.get("studentId");
		System.out.println(integer);
		ExamMessageInfo examMessageInfo = examMessageInfoMapper.findExamByStudentId(integer).get(0);
		System.out.println(examMessageInfo);
		return Result.success(examMessageInfo);
		
	}
	
	@RequestMapping("/getExamResult")
	@ResponseBody
	public LayUITableData getExamResult(@RequestBody Map<String, Integer> map) {
		List<ExamResult> data = examResultMapper.findAllExamResultByTutorId(map.get("tutorId"));
		LayUITableData tableData = new LayUITableData();
		tableData.setCode("0");
		tableData.setCount(data.size());
		tableData.setData(data);
		return tableData;
	}
	
	@RequestMapping("/sendEmailMessage")
	@ResponseBody
	public Result<String> getExamResult(@RequestBody List<ExamResult> examResults) {
		
		
		System.out.println(examResults);
		
		for (ExamResult examResult : examResults) {
			Integer studentId = examResult.getStudentId();
			try {
				StudentContactInformation studentContactInformation = studentContactInformationMapper.findContactByStudentId(studentId).get(0);
				
				Verify.sendNotice(studentContactInformation.getEmail(), "恭喜你通过研究生招生考试笔试,请准时参加复试");
			} catch (MessagingException e) {
				System.out.println(e.getLocalizedMessage() + examResult.toString());
				return Result.success("fail");
			} catch (Exception e) {
				log.info(e.getMessage() + ":" + examResult.toString());
				return Result.success("fail");
			}
			
		}
		
		
		return Result.success("success");
	}
	
	@RequestMapping("/getAllStudentInfo")
	@ResponseBody
	public Result<Map<String, Object>> getAllStudentInfo(@RequestBody Map<String, Integer> stringIntegerMap) {
		
		Integer studentId = stringIntegerMap.get("studentId");
		System.out.println(stringIntegerMap + ":" + studentId);
		try {
			Map<String, Object> map = new HashMap<>();
			
			StudentRealNameInfo studentRealNameInfo = studentRealNameInfoService.getStudentRealNameInfoByStudentId(studentId).get(0);
			map.put("studentRealNameInfo", studentRealNameInfo);
			
			StudentCensusRegisterDocument studentCensusRegisterDocument = documentMapper.findDocumentByStudentId(studentId).get(0);
			
			map.put("studentCensusRegisterDocument", studentCensusRegisterDocument);
			
			StudentContactInformation studentContactInformation = studentContactInformationMapper.findContactByStudentId(studentId).get(0);
			map.put("studentContactInformation", studentContactInformation);
			StudentEducationBackground background = educationBackgroundMapper.findByStudentId(studentId * 1l).get(0);
			map.put("background", background);
			
			
			StudentBaseInfo studentBaseInfo = studentBaseInfoService.findByStudentId(studentRealNameInfo).get(0);
			map.put("studentBaseInfo", studentBaseInfo);
			
			return Result.success(map);
		} catch (Exception e) {
			HashMap<String, Object> objectObjectHashMap = new HashMap<>();
			objectObjectHashMap.put("error", e);
			return Result.success(objectObjectHashMap);
		}
		
	}
	
	@RequestMapping("/getAllStudentRealNameInfos")
	@ResponseBody
	public LayUITableData<StudentRealNameInfo> getAllStudentRealNameInfos() {
		List<StudentRealNameInfo> all = studentRealNameInfoService.getAll();
		LayUITableData<StudentRealNameInfo> layUITableData=new LayUITableData<>();
		layUITableData.setData(all);
		layUITableData.setCode("0");
		layUITableData.setCount(all.size());
		return layUITableData;
	}
	
	@RequestMapping("/changeMod")
	@ResponseBody
	public Result<Integer> changeMod(@RequestBody StudentRealNameInfo info) {
		int i = 1;
		info.setChecked(i);
		Integer integer = studentRealNameInfoService.updateChecked(info);
		try {
			Verify.sendNotice(info.getEmail(),"您在mams系统的身份已经通过认证");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return Result.success(integer);
	}
	@RequestMapping("/changeModFail")
	@ResponseBody
	public Result<Integer> changeModFail(@RequestBody StudentRealNameInfo info) {
		int i = 0;
		info.setChecked(i);
		Integer integer = studentRealNameInfoService.updateChecked(info);
		try {
			Verify.sendNotice(info.getEmail(),"您在mams系统的身份没有通过认证");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return Result.success(integer);
	}
	@RequestMapping("/sendExamSuccess")
	@ResponseBody
	public Result<Integer> sendExamSuccess(@RequestBody ExamResult request) {
		Integer studentId=request.getStudentId();
		
		StudentRealNameInfo studentRealNameInfo = studentRealNameInfoService.getStudentRealNameInfoByStudentId(studentId).get(0);
		request.setReceiveStatus(1);
		int value = examResultMapper.updataReceivpSatus(request).intValue();
		String email=studentRealNameInfo.getEmail();
		try {
			Verify.sendNotice(email,"恭喜你通过笔试,请按时参加面试");
			return Result.success(1);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping("/accept")
	@ResponseBody
	public Result<Integer> accept(@RequestBody ExamResult request) {
		Integer studentId=request.getStudentId();
		
		StudentRealNameInfo studentRealNameInfo = studentRealNameInfoService.getStudentRealNameInfoByStudentId(studentId).get(0);
		request.setReceiveStatus(1);
		int value = examResultMapper.updataReceivpSatus(request).intValue();
		String email=studentRealNameInfo.getEmail();
		try {
			Verify.sendNotice(email,"很荣幸的通知你，你已经被我们专业录取，请及准时报到");
			return Result.success(1);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/sendRefuse")
	@ResponseBody
	public Result<Integer> sendRefuse(@RequestBody ExamResult request) {
		Integer studentId=request.getStudentId();
		
		StudentRealNameInfo studentRealNameInfo = studentRealNameInfoService.getStudentRealNameInfoByStudentId(studentId).get(0);
		request.setReceiveStatus(-1);
		int value = examResultMapper.updataReceivpSatus(request).intValue();
		String email=studentRealNameInfo.getEmail();
		try {
			Verify.sendNotice(email,"感谢您报考我们专业，但由于考试结果未达到我们要求的标准，请您早做考虑");
			return Result.success(1);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/getSecondExamResult")
	@ResponseBody
	public LayUITableData getSecondExamResult(@RequestBody Map<String, Integer> map) {
		List<ExamResult> data = examResultMapper.findAllExamResultByTutorIdTwo(map.get("tutorId"));
		LayUITableData tableData = new LayUITableData();
		tableData.setCode("0");
		tableData.setCount(data.size());
		tableData.setData(data);
		return tableData;
	}
	
}
