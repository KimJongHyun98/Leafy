package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.FBoardDTO;
import com.plant.dto.MemberDTO;
import com.plant.dto.NaverDTO;
import com.plant.mapper.LoginMapper;

@Service
public class LoginService {//로그인서비스
	private LoginMapper loginmapper;
	
	public LoginService(LoginMapper loginmapper) {
		super();
		this.loginmapper = loginmapper;
	}
	
	public MemberDTO Login(String id,String passwd) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		return loginmapper.Login(map);
	}

	public int insertMember(MemberDTO dto) {
		return loginmapper.insertMember(dto);	
	}
	
	public int insertNaver(NaverDTO dto) {
		return loginmapper.insertNaver(dto);
	}
	
	public int nickChenk(String nickname) {
		return loginmapper.nickCheck(nickname);
	}
	

	
	

}
