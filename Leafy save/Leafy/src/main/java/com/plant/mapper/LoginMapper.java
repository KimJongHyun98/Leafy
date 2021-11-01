package com.plant.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.MemberDTO;

@Mapper
public interface LoginMapper {
	
	MemberDTO Login(HashMap<String, Object> map);
	int insertMember(MemberDTO dto);
	
}
