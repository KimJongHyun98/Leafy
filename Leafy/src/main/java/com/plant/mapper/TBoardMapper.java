package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.TBCommentDTO;
import com.plant.dto.TBoardDTO;
import com.plant.dto.TFileDTO;

@Mapper
public interface TBoardMapper { // 팁 게시판 매퍼

	ArrayList<TBoardDTO> selectAllTip(int pageNo);
	List<TBoardDTO> selectTipBoard(HashMap<String, Object> map);
	int selectTipBoardNo();
	int insertTipBoard(TBoardDTO dto);
	int insertFileInfo(TFileDTO fileDTO);
	TBoardDTO selectTipBoardContent(int tno);
	ArrayList<TFileDTO> selectFileList(int tno);
	TFileDTO selectFile(int tfno);
	int deleteTipBoard(int tno);
	int updateTipBoard(HashMap<String, Object> map);
	int selectTipBoardCount();
	int addTipBoardCount(int tno);
	List<TBCommentDTO> selectTipBoardComment(int tno);
	TBCommentDTO insertTipComment(TBCommentDTO dto);
	int selectTipBoardSearchCount(HashMap<String, Object> map);
	int insertTipBoardRecommand(HashMap<String, Object> map);
	int deleteTipBoardRecommand(HashMap<String, Object> map); 
	int selectFileNo();
	void insertFileOne(TFileDTO dto);
	
}
