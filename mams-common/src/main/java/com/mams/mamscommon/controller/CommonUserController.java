package com.mams.mamscommon.controller;

import com.mams.mamscommon.entity.Subject;
import com.mams.mamscommon.entity.School;
import com.mams.mamscommon.entity.User;
import com.mams.mamscommon.mapper.SubjectMapper;
import com.mams.mamscommon.mapper.SchoolMapper;
import com.mams.mamscommon.mapper.UserMapper;
import com.mams.mamscommon.service.SubjectService;
import com.mams.mamscommon.utils.EmailUtils;
import com.mams.mamscommon.utils.Result;
import com.mams.mamscommon.utils.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.mail.MessagingException;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author TangCaiping
 * @Date 2021/2/2 11:35
 * @Version 1.0
 * CrossOrigin: 解决跨域问题
 */
@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonUserController {
	@Resource
	SchoolMapper schoolMapper;
	@Resource
	SubjectMapper subjectMapper;
	@Autowired
	SubjectService subjectService;
	@Resource
	UserMapper userMapper;
	
	@RequestMapping("/saveSchool")
	public String saveBaseInfo() {
		
		File file = new File("D:\\graduation\\mams\\mams-common\\src\\main\\resources\\schools.txt");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			School school = new School();
			while (true) {
				line = reader.readLine();
				if (line == null)
					break;
				String[] schoolData = line.split("\t");
				if (schoolData.length < 6 || schoolData[5].equals("专科"))
					continue;
				school.setId(schoolData[0]);
				school.setSchoolName(schoolData[1]);
				school.setSchoolCode(schoolData[2]);
				school.setBelongingDepartment(schoolData[3]);
				school.setLocalAddress(schoolData[4]);
				school.setLevel(schoolData[5]);
				schoolMapper.insert(school);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "success";
	}
	
	@RequestMapping("/saveCourse")
	public String saveCourse() {
		String deptCode = "0810";
		String deptName = "信息与通信工程";
		File file = new File("D:\\graduation\\mams\\mams-common\\src\\main\\resources\\course.txt");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			Subject subject = new Subject();
			while (true) {
				line = reader.readLine();
				if (line == null)
					break;
				String[] factors = line.split(" ");
				subject.setCategory("工科");
				subject.setMajorType("学术型");
				subject.setSubjectCode(factors[0]);
				subject.setSubjectName(factors[1]);
				subject.setDeptCode(deptCode);
				subject.setDeptName(deptName);
				subjectMapper.save(subject);
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "seccess";
	}
	
	@RequestMapping("/getAllDeptName")
	List<String> getAllDeptName() {
		return subjectService.getAllDeptName();
	}
	
	@RequestMapping("/getAllSubjectName")
	List<String> getAllSubjectName() {
		return subjectService.getAllSubjectName();
	}
	
	@RequestMapping("/getAllSchoolNames")
	List<School> getAllSchoolNames() {
		return schoolMapper.getAllSchool();
	}
	
	@RequestMapping("/sendCheckCode")
	Result<String> sendCheckCode(@RequestBody Map<String, String> infoMap) {
		System.out.println(infoMap);
		String checkCode = Verify.getCheckCode();
		try {
			return Result.success(Verify.sendMsg(infoMap.get("email"), checkCode));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return Result.fail("fail");
	}
	
	@RequestMapping("/register")
	Result<User> register(@RequestBody User user) {
		Integer flag = userMapper.save(user);
		if (flag == 1) {
			List<User> byUserId = userMapper.findByUserId(user.getUserId());
			
			if (byUserId.size() == 1)
				return Result.success(byUserId.get(0));
		}
		
		return Result.fail(null);
	}
	
	@RequestMapping("/login")
	Result<User> login(@RequestBody User user) {
 		System.out.println(user);
		List<User> login = userMapper.login(user);
		System.out.println(login);
		if (login.size()==1){
			return Result.success(login.get(0));
		}
		
		return Result.fail(user);
	}
}

