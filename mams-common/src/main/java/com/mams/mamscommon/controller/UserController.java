package com.mams.mamscommon.controller;

import com.mams.mamscommon.entity.School;
import com.mams.mamscommon.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.Set;

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
public class UserController {
	@Resource
	SchoolMapper mapper;
	
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
				mapper.insert(school);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		

		return "success";
	}
}


