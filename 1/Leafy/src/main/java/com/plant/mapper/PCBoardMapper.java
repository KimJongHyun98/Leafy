package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.PCBCommentDTO;
import com.plant.dto.PCBoardDTO;

@Mapper
public interface PCBoardMapper { // 분양게시판 매퍼
	ArrayList<PCBoardDTO> selectAllPCBoard(int page);
	int selectPCBoardCount();
	PCBoardDTO selectPCBoardContent(int fcbno);
	List<PCBCommentDTO> selectPCBoardComment(int fcbno);
	PCBCommentDTO insertPCBComment(PCBCommentDTO pcbcdto);
	int selectPCBoardSearchCount(HashMap<String, Object> map);
	int addPCBoardCount(int fcbno);
	int insertPCBoardRecommand(HashMap<String, Object> map);
	int deletePCBoardRecommand(HashMap<String, Object> map); 
	
}
