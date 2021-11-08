package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("pBoard") // 포토게시판 DTO
public class PBoardDTO {
	// 게시글 번호, 아이디, 게시글 제목, 게시글 내용, 작성일, 조회수, 추천수
	private String creator_id;
	private int pb_no;
	private String pb_title;
	private String pb_content;
	private String pb_create_date;
	private String pb_update_date;
	private String pb_thumbnail_fno;
	private int pb_recommand_count;
	private int pb_visit_count; 

	public PBoardDTO() {
	}

	public PBoardDTO(String creator_id, int pb_no, String pb_title, String pb_content, String pb_create_date,
			String pb_update_date, String pb_thumbnail_fno, int pb_recommand_count, int pb_visit_count) {
		super();
		this.creator_id = creator_id;
		this.pb_no = pb_no;
		this.pb_title = pb_title;
		this.pb_content = pb_content;
		this.pb_create_date = pb_create_date;
		this.pb_update_date = pb_update_date;
		this.pb_thumbnail_fno = pb_thumbnail_fno;
		this.pb_recommand_count = pb_recommand_count;
		this.pb_visit_count = pb_visit_count;
	}
	
	public PBoardDTO(String creator_id, int pb_no, String pb_title, String pb_content, String pb_create_date,
			String pb_update_date, int pb_recommand_count, int pb_visit_count) {
		super();
		this.creator_id = creator_id;
		this.pb_no = pb_no;
		this.pb_title = pb_title;
		this.pb_content = pb_content;
		this.pb_create_date = pb_create_date;
		this.pb_update_date = pb_update_date;
		this.pb_recommand_count = pb_recommand_count;
		this.pb_visit_count = pb_visit_count;
	}

	public String getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}

	public int getPb_no() {
		return pb_no;
	}

	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}

	public String getPb_title() {
		return pb_title;
	}

	public void setPb_title(String pb_title) {
		this.pb_title = pb_title;
	}

	public String getPb_content() {
		return pb_content;
	}

	public void setPb_content(String pb_content) {
		this.pb_content = pb_content;
	}

	public String getPb_create_date() {
		return pb_create_date;
	}

	public void setPb_create_date(String pb_create_date) {
		this.pb_create_date = pb_create_date;
	}

	public String getPb_update_date() {
		return pb_update_date;
	}

	public void setPb_update_date(String pb_update_date) {
		this.pb_update_date = pb_update_date;
	}

	public String getPb_thumbnail_fno() {
		return pb_thumbnail_fno;
	}

	public void setPb_thumbnail_fno(String pb_thumbnail_fno) {
		this.pb_thumbnail_fno = pb_thumbnail_fno;
	}

	public int getPb_recommand_count() {
		return pb_recommand_count;
	}

	public void setPb_recommand_count(int pb_recommand_count) {
		this.pb_recommand_count = pb_recommand_count;
	}

	public int getPb_visit_count() {
		return pb_visit_count;
	}

	public void setPb_visit_count(int pb_visit_count) {
		this.pb_visit_count = pb_visit_count;
	}

	@Override
	public String toString() {
		return "PBoardDTO [creator_id=" + creator_id + ", pb_no=" + pb_no + ", pb_title=" + pb_title + ", pb_content="
				+ pb_content + ", pb_create_date=" + pb_create_date + ", pb_update_date=" + pb_update_date
				+ ", pb_thumbnail_fno=" + pb_thumbnail_fno + ", pb_recommand_count=" + pb_recommand_count
				+ ", pb_visit_count=" + pb_visit_count + "]";
	}


}
