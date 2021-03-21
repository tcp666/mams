package com.mams.mamsschool.controller;


import com.mams.mamscommon.utils.Result;
import com.mams.mamscommon.utils.Verify;
import com.mams.mamsschool.entity.Tutor;
import com.mams.mamsschool.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;


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
	
	
	@RequestMapping("/login")
	@ResponseBody
	public Result<Tutor> login(@RequestBody Tutor tutor) {
		List<Tutor> tutors = tutorService.find(tutor);
		if (tutors.size() != 1) {
			return Result.fail(tutor);
			
		}
		return Result.success(tutors.get(0));
	}
	
	@RequestMapping("/signup")
	@ResponseBody
	public Result<String> signUp(Tutor tutor){
		Integer add = tutorService.add(tutor);
		if (add!=1){
			return Result.fail(tutor);
		}
		return Result.success("注册成功");
	}
	
	@RequestMapping("/getCheckCode")
	@ResponseBody
	public Result<String> sendCheckCode(@RequestBody Tutor tutor){
		System.out.println(tutor.getEmail());
		String checkCode = Verify.getCheckCode();
		try {
			return Result.success(Verify.sendMsg(tutor.getEmail(), checkCode));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return  Result.fail(null);
	}
}
