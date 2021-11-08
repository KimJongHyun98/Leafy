package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.PBoardDTO;

@Mapper
public interface PBoardMapper {
	ArrayList<PBoardDTO> selectAllPBoard(int pageNo);
	ArrayList<PBoardDTO> selectMVPBoard();
	int selectPBoardCount();
	ArrayList<PBoardDTO> selectPBoard(HashMap<String, Object> map);
	int selectPBoardSearchCount(HashMap<String, Object> map);
	int addPBoardCount(int pb_no);
	PBoardDTO selectPBoardContent(int pb_no);
//	ArrayList<PBFileDTO> selectFileList(int pb_no);
//	ArrayList<PBCommentDTO> selectPBoardComment(int pb_no);
//	int insertPBComment(PBCommentDTO pbcdto);
	int deletePBComment(int pbc_no);
	int selectPBoardNo();
	int insertPBoard(PBoardDTO pbdto);
//	int insertFileInfo(PBFileDTO pbFileDTO);
	int updatePBoard(HashMap<String, Object> map);
	int deletePBoard(int pb_no);
//	PBFileDTO selectFile(int pb_fno);
//	PBFileDTO selectPBThumbnail(int pb_fno);
}
