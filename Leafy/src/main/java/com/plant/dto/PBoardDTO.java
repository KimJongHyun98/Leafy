package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("pBoard") // 포토게시판 DTO
public class PBoardDTO {
	// 게시글 번호, 아이디, 게시글 제목, 게시글 내용, 작성일, 조회수, 추천수
	private int pb_no;
	private String creator_id;
	private String pb_title;
	private String pb_content;
<<<<<<< HEAD
	private String pb_date;
	private String pb_addfile_url;
	private int pb_visit; 
	private int pb_recommand;
=======
	private String pb_create_date;
	private String pb_update_date;
	private String pb_thumbnail_fno;
	private int pb_recommand_count;
	private int pb_visit_count; 
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a

	public PBoardDTO() {
	}

<<<<<<< HEAD
	public PBoardDTO(int pb_no, String creator_id, String pb_title, String pb_content, String pb_date,
			String pb_addfile_url, int pb_visit, int pb_recommand) {
=======
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
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
		super();
		this.pb_no = pb_no;
		this.creator_id = creator_id;
		this.pb_title = pb_title;
		this.pb_content = pb_content;
		this.pb_date = pb_date;
		this.pb_addfile_url = pb_addfile_url;
		this.pb_visit = pb_visit;
		this.pb_recommand = pb_recommand;
	}

	public int getPb_no() {
		return pb_no;
	}

	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}

	public String getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
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

	public String getPb_date() {
		return pb_date;
	}

	public void setPb_date(String pb_date) {
		this.pb_date = pb_date;
	}

	public String getPb_addfile_url() {
		return pb_addfile_url;
	}

	public void setPb_addfile_url(String pb_addfile_url) {
		this.pb_addfile_url = pb_addfile_url;
	}

<<<<<<< HEAD
	public int getPb_visit() {
		return pb_visit;
=======
	public String getPb_thumbnail_fno() {
		return pb_thumbnail_fno;
	}

	public void setPb_thumbnail_fno(String pb_thumbnail_fno) {
		this.pb_thumbnail_fno = pb_thumbnail_fno;
	}

	public int getPb_recommand_count() {
		return pb_recommand_count;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	}

	public void setPb_visit(int pb_visit) {
		this.pb_visit = pb_visit;
	}

	public int getPb_recommand() {
		return pb_recommand;
	}

	public void setPb_recommand(int pb_recommand) {
		this.pb_recommand = pb_recommand;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "PBoardDTO [pb_no=" + pb_no + ", creator_id=" + creator_id + ", pb_title=" + pb_title + ", pb_content="
				+ pb_content + ", pb_date=" + pb_date + ", pb_addfile_url=" + pb_addfile_url + ", pb_visit=" + pb_visit
				+ ", pb_recommand=" + pb_recommand + "]";
	}

	

	
=======
		return "PBoardDTO [creator_id=" + creator_id + ", pb_no=" + pb_no + ", pb_title=" + pb_title + ", pb_content="
				+ pb_content + ", pb_create_date=" + pb_create_date + ", pb_update_date=" + pb_update_date
				+ ", pb_thumbnail_fno=" + pb_thumbnail_fno + ", pb_recommand_count=" + pb_recommand_count
				+ ", pb_visit_count=" + pb_visit_count + "]";
	}


>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
}
