package com.mams.mamsstudent.mapper;

import com.mams.mamsstudent.entity.StudentRewardAndPunishment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName StudentRewardAndPunishmentMapper
 * @Description TODO
 * @Author Haining
 * @Date 2021/4/17 21:47
 * @Version 1.0
 */

@Mapper
public interface StudentRewardAndPunishmentMapper {
	@Insert("insert into student_reward_and_punishment values(#{studentId},#{rewardMessage},#{punishmentMessage})")
	Integer add(StudentRewardAndPunishment rewardAndPunishment);
}
