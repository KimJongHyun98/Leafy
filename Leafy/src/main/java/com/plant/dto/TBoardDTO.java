package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("tBoard") // 팁 게시판 DTO
public class TBoardDTO {
	private int tno;
	private String id;
	private String tip_title;
	private String tip_content;
	private String tip_date;
	private String tip_addfile_url;
	private int tip_recommand;
	private int tip_visit;
	private int tip_comment;
	
	public TBoardDTO() {
	}
	public TBoardDTO(int tno, String id, String tip_title, String tip_content, String tip_date, String tip_addfile_url,
			int tip_recommand, int tip_visit, int tip_comment) {
		super();
		this.tno = tno;
		this.id = id;
		this.tip_title = tip_title;
		this.tip_content = tip_content;
		this.tip_date = tip_date;
		this.tip_addfile_url = tip_addfile_url;
		this.tip_recommand = tip_recommand;
		this.tip_visit = tip_visit;
		this.tip_comment = tip_comment;
	}
	@Override
	public String toString() {
		return "TBoardDTO [tno=" + tno + ", id=" + id + ", tip_title=" + tip_title + ", tip_content=" + tip_content
				+ ", tip_date=" + tip_date + ", tip_addfile_url=" + tip_addfile_url + ", tip_recommand=" + tip_recommand
				+ ", tip_visit=" + tip_visit + ", tip_comment=" + tip_comment + "]";
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTip_title() {
		return tip_title;
	}
	public void setTip_title(String tip_title) {
		this.tip_title = tip_title;
	}
	public String getTip_content() {
		return tip_content;
	}
	public void setTip_content(String tip_content) {
		this.tip_content = tip_content;
	}
	public String getTip_date() {
		return tip_date;
	}
	public void setTip_date(String tip_date) {
		this.tip_date = tip_date;
	}
	public String getTip_addfile_url() {
		return tip_addfile_url;
	}
	public void setTip_addfile_url(String tip_addfile_url) {
		this.tip_addfile_url = tip_addfile_url;
	}
	public int getTip_recommand() {
		return tip_recommand;
	}
	public void setTip_recommand(int tip_recommand) {
		this.tip_recommand = tip_recommand;
	}
	public int getTip_visit() {
		return tip_visit;
	}
	public void setTip_visit(int tip_visit) {
		this.tip_visit = tip_visit;
	}
	public int getTip_comment() {
		return tip_comment;
	}
	public void setTip_comment(int tip_comment) {
		this.tip_comment = tip_comment;
	}
	
	
	
	
}
