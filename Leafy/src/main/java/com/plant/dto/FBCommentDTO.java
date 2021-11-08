package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("fbComment") // 자유게시판 댓글 DTO
public class FBCommentDTO {
	private int fbc_no;
	private int fb_no;
	private String commentor_id;
	private String fb_comment_content;
	private String fb_comment_date;

	public FBCommentDTO() {
	}

	public FBCommentDTO(int fbc_no, int fb_no, String commentor_id, String fb_comment_content, String fb_comment_date) {
		super();
		this.fbc_no = fbc_no;
		this.fb_no = fb_no;
		this.commentor_id = commentor_id;
		this.fb_comment_content = fb_comment_content;
		this.fb_comment_date = fb_comment_date;
	}

	public int getFbc_no() {
		return fbc_no;
	}

	public void setFbc_no(int fbc_no) {
		this.fbc_no = fbc_no;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	public String getCommentor_id() {
		return commentor_id;
	}

	public void setCommentor_id(String commentor_id) {
		this.commentor_id = commentor_id;
	}

	public String getFb_comment_content() {
		return fb_comment_content;
	}

	public void setFb_comment_content(String fb_comment_content) {
		this.fb_comment_content = fb_comment_content;
	}

	public String getFb_comment_date() {
		return fb_comment_date;
	}

	public void setFb_comment_date(String fb_comment_date) {
		this.fb_comment_date = fb_comment_date;
	}

	@Override
	public String toString() {
		return "FBCommentDTO [fbc_no=" + fbc_no + ", fb_no=" + fb_no + ", commentor_id=" + commentor_id
				+ ", fb_comment_content=" + fb_comment_content + ", fb_comment_date=" + fb_comment_date + "]";
	}
	
	
}
