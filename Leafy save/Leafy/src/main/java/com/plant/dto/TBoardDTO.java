package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("tBoard") // 팁 게시판 DTO
public class TBoardDTO {
	private int tb_no;
	private String id;
	private String tb_title;
	private String tb_content;
	private String tb_date;
	private String tb_addfile_url;
	private int tb_recommand;
	private int tb_visit;
	private int tb_comment;
	
	public TBoardDTO() {
	}
	
	public TBoardDTO(int tb_no, String id, String tb_title, String tb_content, String tb_date, String tb_addfile_url,
			int tb_recommand, int tb_visit, int tb_comment) {
		super();
		this.tb_no = tb_no;
		this.id = id;
		this.tb_title = tb_title;
		this.tb_content = tb_content;
		this.tb_date = tb_date;
		this.tb_addfile_url = tb_addfile_url;
		this.tb_recommand = tb_recommand;
		this.tb_visit = tb_visit;
		this.tb_comment = tb_comment;
	}
	
	@Override
	public String toString() {
		return "TBoardDTO [tb_no=" + tb_no + ", id=" + id + ", tb_title=" + tb_title + ", tb_content=" + tb_content
				+ ", tb_date=" + tb_date + ", tb_addfile_url=" + tb_addfile_url + ", tb_recommand=" + tb_recommand
				+ ", tb_visit=" + tb_visit + ", tb_comment=" + tb_comment + "]";
	}
	
	public int getTb_no() {
		return tb_no;
	}
	public void setTb_no(int tb_no) {
		this.tb_no = tb_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTb_title() {
		return tb_title;
	}
	public void setTb_title(String tb_title) {
		this.tb_title = tb_title;
	}
	public String getTb_content() {
		return tb_content;
	}
	public void setTb_content(String tb_content) {
		this.tb_content = tb_content;
	}
	public String getTb_date() {
		return tb_date;
	}
	public void setTb_date(String tb_date) {
		this.tb_date = tb_date;
	}
	public String getTb_addfile_url() {
		return tb_addfile_url;
	}
	public void setTb_addfile_url(String tb_addfile_url) {
		this.tb_addfile_url = tb_addfile_url;
	}
	public int getTb_recommand() {
		return tb_recommand;
	}
	public void setTb_recommand(int tb_recommand) {
		this.tb_recommand = tb_recommand;
	}
	public int getTb_visit() {
		return tb_visit;
	}
	public void setTb_visit(int tb_visit) {
		this.tb_visit = tb_visit;
	}
	public int getTb_comment() {
		return tb_comment;
	}
	public void setTb_comment(int tb_comment) {
		this.tb_comment = tb_comment;
	}
	
	
}
