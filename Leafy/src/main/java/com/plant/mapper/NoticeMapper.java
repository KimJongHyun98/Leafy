package com.plant.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {//고객센터(공지사항) 매퍼

	ArrayList<NoticeDTO> selectNotice(int pageNo); 

}
