package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBoardDTO;

@Mapper
public interface FBoardMapper { // 자유게시판 매퍼

	ArrayList<FBoardDTO> selectAllFBoard(int pageNo);
	int selectFBoardCount();
	ArrayList<FBoardDTO> selectFBoard(HashMap<String, Object> map);
	FBoardDTO selectFBoardContent(int fb_no);
	List<FBCommentDTO> selectFBoardComment(int fb_no);
	FBCommentDTO insertFBComment(FBCommentDTO fbcdto);
	int selectFBoardSearchCount(HashMap<String, Object> map);
	int addFBoardCount(int fb_no);
	int insertFBoardRecommand(HashMap<String, Object> map);
	int deleteFBoardRecommand(HashMap<String, Object> map); 
	
}
