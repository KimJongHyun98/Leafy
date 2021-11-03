package com.plant.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.plant.dto.messageDTO;

@Mapper
public interface MessageMapper {

	ArrayList<messageDTO> messageList(messageDTO dto);

}
