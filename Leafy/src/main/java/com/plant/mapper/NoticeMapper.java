package com.plant.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.NoticeDTO;
import com.plant.dto.NoticeFileDTO;

@Mapper
public interface NoticeMapper {//고객센터(공지사항) 매퍼

	ArrayList<NoticeDTO> selectNotice(int pageNo);
	int selectNoticeNo();
	int insertNotice(NoticeDTO dto);
	int insertFileInfo(NoticeFileDTO fileDTO);
	NoticeDTO selectNoticeContent(int nbno);
	ArrayList<NoticeFileDTO> selectFileList(int nbno);
	NoticeFileDTO selectFile(int nfno);
	int deleteNotice(int nbno);
	int updateNotice(HashMap<String, Object> map);
	int selectNoticeCount();
	int addNoticeCount(int bno);
	int selectFileNo();
	void insertFileOne(NoticeFileDTO dto);
}
