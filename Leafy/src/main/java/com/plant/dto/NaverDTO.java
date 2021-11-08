package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("naver") // 네이버로그인 저장 
public class NaverDTO {
	public String name;
	public String mobile;
	public String code;//접근 토큰 
	public String state;//토근 url
	public String id;//동일인 식별 정보 동일인 식별 정보는 네이버 아이디마다 고유하게 발급되는 값.
	
	
	public NaverDTO() {
		
	}

	
	public NaverDTO(String name, String mobile, String code, String state, String id) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.code = code;
		this.state = state;
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}
