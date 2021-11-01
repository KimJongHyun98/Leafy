package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("fBoard") // 자유게시판 DTO
public class FBoardDTO {
	// 회원아이디, 게시글번호, 게시글제목, 게시글내용, 작성일, 수정일, 첨부파일경로, 추천수, 조회수
	private String creator_id;
	private int fb_no;
	private String fb_title;
	private String fb_content;
	private String fb_create_date;
	private String fb_update_date;
	private int fb_recommand_count;
	private int fb_visit_count;

	public FBoardDTO() {
	}

	public FBoardDTO(String creator_id, int fb_no, String fb_title, String fb_content, String fb_create_date,
			String fb_update_date, int fb_recommand_count, int fb_visit_count) {
		super();
		this.creator_id = creator_id;
		this.fb_no = fb_no;
		this.fb_title = fb_title;
		this.fb_content = fb_content;
		this.fb_create_date = fb_create_date;
		this.fb_update_date = fb_update_date;
		this.fb_recommand_count = fb_recommand_count;
		this.fb_visit_count = fb_visit_count;
	}

	public String getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	public String getFb_title() {
		return fb_title;
	}

	public void setFb_title(String fb_title) {
		this.fb_title = fb_title;
	}

	public String getFb_content() {
		return fb_content;
	}

	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}

	public String getFb_create_date() {
		return fb_create_date;
	}

	public void setFb_create_date(String fb_create_date) {
		this.fb_create_date = fb_create_date;
	}

	public String getFb_update_date() {
		return fb_update_date;
	}

	public void setFb_update_date(String fb_update_date) {
		this.fb_update_date = fb_update_date;
	}

	public int getFb_recommand_count() {
		return fb_recommand_count;
	}

	public void setFb_recommand_count(int fb_recommand_count) {
		this.fb_recommand_count = fb_recommand_count;
	}

	public int getFb_visit_count() {
		return fb_visit_count;
	}

	public void setFb_visit_count(int fb_visit_count) {
		this.fb_visit_count = fb_visit_count;
	}

	@Override
	public String toString() {
		return "FBoardDTO [creator_id=" + creator_id + ", fb_no=" + fb_no + ", fb_title=" + fb_title + ", fb_content="
				+ fb_content + ", fb_create_date=" + fb_create_date + ", fb_update_date=" + fb_update_date
				+ ", fb_recommand_count=" + fb_recommand_count + ", fb_visit_count=" + fb_visit_count + "]";
	}

}
