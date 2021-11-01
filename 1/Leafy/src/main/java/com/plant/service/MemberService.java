package com.plant.service;

import org.springframework.stereotype.Service;

import com.plant.mapper.MemberMapper;

@Service
public class MemberService { // 회원게시판 서비스
	private MemberMapper mMapper;

	public MemberService(MemberMapper mMapper) {
		super();
		this.mMapper = mMapper;
	}
	
}
