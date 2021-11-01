package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("tbComment") // 팁 게시판 댓글 DTO
public class TBCommentDTO {
	private String tb_no;
	private String id;
	private String tb_comment_content;
	private int tb_comment_like;
	private String tb_comment_date;
	
	
	public TBCommentDTO() {
	}


	public TBCommentDTO(String tb_no, String id, String tb_comment_content, int tb_comment_like,
			String tb_comment_date) {
		super();
		this.tb_no = tb_no;
		this.id = id;
		this.tb_comment_content = tb_comment_content;
		this.tb_comment_like = tb_comment_like;
		this.tb_comment_date = tb_comment_date;
	}


	@Override
	public String toString() {
		return "TBCommentDTO [tb_no=" + tb_no + ", id=" + id + ", tb_comment_content=" + tb_comment_content
				+ ", tb_comment_like=" + tb_comment_like + ", tb_comment_date=" + tb_comment_date + "]";
	}


	public String getTb_no() {
		return tb_no;
	}


	public void setTb_no(String tb_no) {
		this.tb_no = tb_no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTb_comment_content() {
		return tb_comment_content;
	}


	public void setTb_comment_content(String tb_comment_content) {
		this.tb_comment_content = tb_comment_content;
	}


	public int getTb_comment_like() {
		return tb_comment_like;
	}


	public void setTb_comment_like(int tb_comment_like) {
		this.tb_comment_like = tb_comment_like;
	}


	public String getTb_comment_date() {
		return tb_comment_date;
	}


	public void setTb_comment_date(String tb_comment_date) {
		this.tb_comment_date = tb_comment_date;
	}
	
	
	
}
