package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBFileDTO;
import com.plant.dto.FBoardDTO;

@Mapper
public interface FBoardMapper { // 자유게시판 매퍼

	ArrayList<FBoardDTO> selectAllFBoard(int pageNo);
	int selectFBoardCount();
	ArrayList<FBoardDTO> selectFBoard(HashMap<String, Object> map);
	FBoardDTO selectFBoardContent(int fb_no);
	List<FBCommentDTO> selectFBoardComment(int fb_no);
	int insertFBComment(FBCommentDTO fbcdto);
	int selectFBoardSearchCount(HashMap<String, Object> map);
	int addFBoardCount(int fb_no);
	int insertFBoardRecommand(HashMap<String, Object> map);
	int deleteFBoardRecommand(HashMap<String, Object> map);
	int selectFBoardNo();
	int insertFBoard(FBoardDTO fbdto);
	int insertFileInfo(FBFileDTO fbfdto);
	ArrayList<FBFileDTO> selectFileList(int fb_no);
	FBFileDTO selectFile(int fb_fno);
	int updateFBoard(HashMap<String, Object> map);
	int deleteFBoard(int fb_no);
	int deleteFBComment(int fbc_no); 
	
}
