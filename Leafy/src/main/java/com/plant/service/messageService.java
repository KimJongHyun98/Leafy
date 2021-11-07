package com.plant.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.plant.dto.messageDTO;
import com.plant.mapper.MessageMapper;

@Service
public class messageService {
	
	private static MessageMapper msMapper;

	public messageService(MessageMapper msMapper) {
		this.msMapper = msMapper;
	}
	
	public static ArrayList<messageDTO> messageList(messageDTO dto){
		String nick = dto.getNick();
		
		ArrayList<messageDTO> list = (ArrayList) msMapper.messageList(dto);
		
		for (messageDTO mto : list) {
			mto.setNick(nick);
			//현재 사용자가 해당 room에서 안읽은 메세지의 갯수를 가져온다.
			int unread = msMapper.count_unread(mto);
			//현재 사용자가 메세지를 주고 받는 상대 profile을 가져온다.
			String profile = msMapper.get_other_profile(mto);
			//안읽은 메세지 갯수를 mto에 set한다.
			mto.setUnread(unread);
			//메세지 상대의 프로필 사진을 mto에 set 한다.
			mto.setProfile(profile);
			//메세지 상대의 닉넴을 세팅한다
			if (nick.equals(mto.getSend_nick())) {
				mto.setOther_nick(mto.getRecv_nick());
			}else {
				mto.setOther_nick(mto.getSend_nick());
			}
		}
		return list;
	}
	
	public static ArrayList<messageDTO> roomContentList(messageDTO dto){
		
		System.out.println("room : " + dto.getRoom());
		System.out.println("recv_nick : " + dto.getRecv_nick());
		System.out.println("nick : " + dto.getNick());
		
		ArrayList<messageDTO> clist = (ArrayList) msMapper.roomContentList(dto);
		
		msMapper.messageReadChk(dto);
		
		return clist;
	}
	
	public static int messageSendInlist(messageDTO dto) {
		
		if(dto.getRoom() == 0) {
			int exist_chat = msMapper.existChat(dto);
			
			if(exist_chat == 0) {
				int max_room = msMapper.maxRoom(dto);
				dto.setRoom(max_room + 1);
			}else {
				int room = Integer.parseInt(msMapper.selectRoom(dto));
				dto.setRoom(room);
			}
		}
		
		int flag = msMapper.messageSendInlist(dto);
		return flag;
	}
}
