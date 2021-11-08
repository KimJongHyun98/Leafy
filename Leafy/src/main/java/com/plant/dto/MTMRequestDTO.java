package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("mtmRequest") //고객센터-1:1문의 DTO
public class MTMRequestDTO { 
	private String id;
	private String mtm_request_date;
	private String mtm_request_title;
	private String mtm_request_content;
	private String mtm_request_addfile_url;
	private int mtm_request_status;
	
	
	public MTMRequestDTO() {
		super();
	}
	
	
	public MTMRequestDTO(String id, String mtm_request_date, String mtm_request_title, String mtm_request_content,
			String mtm_request_addfile_url, int mtm_request_status) {
		super();
		this.id = id;
		this.mtm_request_date = mtm_request_date;
		this.mtm_request_title = mtm_request_title;
		this.mtm_request_content = mtm_request_content;
		this.mtm_request_addfile_url = mtm_request_addfile_url;
		this.mtm_request_status = mtm_request_status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMtm_request_date() {
		return mtm_request_date;
	}
	public void setMtm_request_date(String mtm_request_date) {
		this.mtm_request_date = mtm_request_date;
	}
	public String getMtm_request_title() {
		return mtm_request_title;
	}
	public void setMtm_request_title(String mtm_request_title) {
		this.mtm_request_title = mtm_request_title;
	}
	public String getMtm_request_content() {
		return mtm_request_content;
	}
	public void setMtm_request_content(String mtm_request_content) {
		this.mtm_request_content = mtm_request_content;
	}
	public String getMtm_request_addfile_url() {
		return mtm_request_addfile_url;
	}
	public void setMtm_request_addfile_url(String mtm_request_addfile_url) {
		this.mtm_request_addfile_url = mtm_request_addfile_url;
	}
	public int getMtm_request_status() {
		return mtm_request_status;
	}
	public void setMtm_request_status(int mtm_request_status) {
		this.mtm_request_status = mtm_request_status;
	}
	
	
}
