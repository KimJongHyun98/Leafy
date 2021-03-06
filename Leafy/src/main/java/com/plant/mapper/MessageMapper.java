package com.plant.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.messageDTO;

@Mapper
public interface MessageMapper {

	ArrayList<messageDTO> messageList(messageDTO dto);

	int countUnread(messageDTO mto);

	String getOtherProfile(messageDTO mto);

	ArrayList roomContentList(messageDTO dto);

	void messageReadChk(messageDTO dto);

	int existChat(messageDTO dto);

	int maxRoom(messageDTO dto);

	String selectRoom(messageDTO dto);

	int messageSendInlist(messageDTO dto);

}
