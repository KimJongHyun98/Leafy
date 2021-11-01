package com.plant.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.plant.dto.NoticeDTO;
import com.plant.mapper.NoticeMapper;

@Service  //고객센터-공지사항 서비스
public class NoticeService {
	private NoticeMapper mapper;
	
	public NoticeService(NoticeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public ArrayList<NoticeDTO> selectNotice(int pageNo) {
		return mapper.selectNotice(pageNo);
	}

}
