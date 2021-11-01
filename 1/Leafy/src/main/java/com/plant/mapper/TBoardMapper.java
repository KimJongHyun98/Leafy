package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.TBoardDTO;

@Mapper
public interface TBoardMapper { // 팁 게시판 매퍼

	ArrayList<TBoardDTO> selectAllTBoard(int pageNo);
	int selectTBoardCount();
	List<TBoardDTO> selectTBoard(HashMap<String, Object> map);

}
