package com.plant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.MemberDTO;
import com.plant.mapper.LoginMapper;

@Service
public class LoginService {//로그인서비스
	private LoginMapper loginmapper;
	
	public LoginService(LoginMapper loginmapper) {
		this.loginmapper = loginmapper;
	}
	
	public ArrayList<MemberDTO> LoginupService(){
		return loginmapper.LogonAllpage();
	}



	
	

}
