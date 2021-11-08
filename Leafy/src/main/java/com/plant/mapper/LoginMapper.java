package com.plant.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.FBoardDTO;
import com.plant.dto.MemberDTO;
import com.plant.dto.NaverDTO;

@Mapper
public interface LoginMapper {
	
	MemberDTO Login(HashMap<String, Object> map);
	int insertMember(MemberDTO dto);
	int insertNaver(NaverDTO dto);
	int nickCheck(String nickname);
	
	
	
}
