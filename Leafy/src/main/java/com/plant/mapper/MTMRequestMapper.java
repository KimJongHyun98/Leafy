package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.MTMFileDTO;
import com.plant.dto.MTMRequestDTO;

@Mapper
public interface MTMRequestMapper { //고객센터(1:1문의) 매퍼

	ArrayList<MTMRequestDTO> selectAllMTM(int pageNo);
	int selectMTMNo();
	void insertMTM(MTMRequestDTO mtmRequestDTO);
	void insertFileInfo(MTMFileDTO mtmFileDTO);
	MTMRequestDTO selectMTMContent(int mno);
	ArrayList<MTMFileDTO> selectFileList(int mno);
	MTMFileDTO selectFile (int fno);
	int deleteMTMRequest(int mno);
	int updateMTMRequest(HashMap<String, Object> map);
	int selectMTMRequestCount();
	int addMTMRequestCount(int mno);
	int selectFileNo();
	void insertFileOne(MTMFileDTO dto);
}
