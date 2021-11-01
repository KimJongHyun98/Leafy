package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.plant.dto.MTMFileDTO;
import com.plant.dto.MTMRequestDTO;
import com.plant.mapper.MTMRequestMapper;

@Service
public class MTMRequestService {//고객센터-1:1문의 서비스
	private MTMRequestMapper mtmRequestMapper;
	
	public MTMRequestService(MTMRequestMapper mtmRequestMapper) {
		super();
		this.mtmRequestMapper = mtmRequestMapper;
	}

	public ArrayList<MTMRequestDTO> selectAllMTM(int pageNo) {
		return mtmRequestMapper.selectAllMTM(pageNo);
	}

	public int selectMTMRequestCount() {
		return mtmRequestMapper.selectMTMRequestCount();
	}
	
	//이미지 파일 업로드 - ckeditor
		public int insertFileOne(MTMFileDTO dto) {
			int fno = mtmRequestMapper.selectFileNo();
			dto.setFno(fno);
			mtmRequestMapper.insertFileOne(dto);
			return fno;
		}
	public int insertMTM(MTMRequestDTO mtmRequestDTO) {
		int mno = mtmRequestMapper.selectMTMNo();
		mtmRequestDTO.setMno(mno);
		mtmRequestMapper.insertMTM(mtmRequestDTO);
		return mno;
	}

	public void insertFileList(ArrayList<MTMFileDTO> mtmflist) {
		for(int i=0;i<mtmflist.size();i++) {
			mtmRequestMapper.insertFileInfo(mtmflist.get(i));
		}
	}

	public MTMRequestDTO selectMTMContent(int mno) {
		return mtmRequestMapper.selectMTMContent(mno);
	}

	public ArrayList<MTMFileDTO> selectFileList(int mno) {
		return mtmRequestMapper.selectFileList(mno);
	}

	public MTMFileDTO selectFile(int fno) {
		return mtmRequestMapper.selectFile(fno);
	}

	public void deleteMTMRequest(int mno) {
		mtmRequestMapper.deleteMTMRequest(mno);
	}

	public void updateMTMRequest(int mno, String mtm_request_title, String mtm_request_content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mno", mno);
		map.put("mtm_request_title", mtm_request_title);
		map.put("mtm_request_content", mtm_request_content);
		mtmRequestMapper.updateMTMRequest(map);		
	}

	public void addMTMRequestCount(int mno) {
		mtmRequestMapper.addMTMRequestCount(mno);
		
	}

	
}
