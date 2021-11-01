package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("pbComment") // 포토게시판 댓글 DTO
public class PBCommentDTO {
	private int pbc_no;
	private int pb_no;
	private String commentor_id;
	private String pb_comment_content;
	private String pb_comment_date;

	public PBCommentDTO() {
	}

	public PBCommentDTO(int pbc_no, int pb_no, String commentor_id, String pb_comment_content, String pb_comment_date) {
		super();
		this.pbc_no = pbc_no;
		this.pb_no = pb_no;
		this.commentor_id = commentor_id;
		this.pb_comment_content = pb_comment_content;
		this.pb_comment_date = pb_comment_date;
	}

	public PBCommentDTO(int pb_no, String commentor_id, String pb_comment_content) {
		super();
		this.pb_no = pb_no;
		this.commentor_id = commentor_id;
		this.pb_comment_content = pb_comment_content;
	}

	public int getPbc_no() {
		return pbc_no;
	}

	public void setPbc_no(int pbc_no) {
		this.pbc_no = pbc_no;
	}

	public int getPb_no() {
		return pb_no;
	}

	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}

	public String getCommentor_id() {
		return commentor_id;
	}

	public void setCommentor_id(String commentor_id) {
		this.commentor_id = commentor_id;
	}

	public String getPb_comment_content() {
		return pb_comment_content;
	}

	public void setPb_comment_content(String pb_comment_content) {
		this.pb_comment_content = pb_comment_content;
	}

	public String getPb_comment_date() {
		return pb_comment_date;
	}

	public void setPb_comment_date(String pb_comment_date) {
		this.pb_comment_date = pb_comment_date;
	}

	@Override
	public String toString() {
		return "PBCommentDTO [pbc_no=" + pbc_no + ", pb_no=" + pb_no + ", commentor_id=" + commentor_id
				+ ", pb_comment_content=" + pb_comment_content + ", pb_comment_date=" + pb_comment_date + "]";
	}
	
	

	
}
