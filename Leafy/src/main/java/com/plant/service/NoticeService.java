package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.plant.dto.NoticeDTO;
import com.plant.dto.NoticeFileDTO;
import com.plant.mapper.NoticeMapper;

@Service  //고객센터-공지사항 서비스
public class NoticeService {
	private NoticeMapper noticeMapper;
	
	public NoticeService(NoticeMapper mapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	public ArrayList<NoticeDTO> selectNotice(int pageNo) {
		return noticeMapper.selectNotice(pageNo);
	}

	public int insertNotice(NoticeDTO dto) {
		int nbno = noticeMapper.selectNoticeNo();
		dto.setNbno(nbno);
		noticeMapper.insertNotice(dto);
		return nbno;
	}
	//이미지 파일 업로드 - ckeditor
	public int insertFileOne(NoticeFileDTO dto) {
		int nfno = noticeMapper.selectFileNo();
		dto.setNfno(nfno);
		noticeMapper.insertFileOne(dto);
		return nfno;
	}
	
	public void insertFileList(ArrayList<NoticeFileDTO> nflist) {
		for(int i=0;i<nflist.size();i++) {
			noticeMapper.insertFileInfo(nflist.get(i));
		}
	}

	public NoticeDTO selectNoticeContent(int nbno) {
		return noticeMapper.selectNoticeContent(nbno);
	}

	public ArrayList<NoticeFileDTO> selectFileList(int nbno) {
		return noticeMapper.selectFileList(nbno);
	}

	public NoticeFileDTO selectFile(int nfno) {
		return noticeMapper.selectFile(nfno);
	}

	public void deleteNotice(int nbno) {
		noticeMapper.deleteNotice(nbno);
	}

	public void updateNotice(int nbno, String notice_title, String notice_content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nbno", nbno);
		map.put("notice_title", notice_title);
		map.put("notice_content", notice_content);
		noticeMapper.updateNotice(map);		
	}

	public int selectNoticeCount() {
		return noticeMapper.selectNoticeCount();
	}

	public void addNoticeCount(int nbno) {
		noticeMapper.addNoticeCount(nbno);
	}

}
