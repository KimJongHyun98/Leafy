package com.plant.mapper;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.MemberDTO;

@Mapper
public interface LoginMapper {
	ArrayList<MemberDTO> LogonAllpage();
}
