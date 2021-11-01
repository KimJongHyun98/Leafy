package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("notice") //고객센터-공지사항 DTO
public class NoticeDTO { 
	
	private int nbno;
	private String id;
	private String notice_title;
	private String notice_content;
	private String notice_addfile_url;
	private String notice_date;
	private int notice_visit;
	
	public NoticeDTO() {
		super();
	}
	
	public NoticeDTO(int nbno, String id, String notice_title, String notice_content, String notice_addfile_url,
			String notice_date, int notice_visit) {
		super();
		this.nbno = nbno;
		this.id = id;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_addfile_url = notice_addfile_url;
		this.notice_date = notice_date;
		this.notice_visit = notice_visit;
	}
	public int getNbno() {
		return nbno;
	}
	public void setNbno(int nbno) {
		this.nbno = nbno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_addfile_url() {
		return notice_addfile_url;
	}
	public void setNotice_addfile_url(String notice_addfile_url) {
		this.notice_addfile_url = notice_addfile_url;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public int getNotice_visit() {
		return notice_visit;
	}
	public void setNotice_visit(int notice_visit) {
		this.notice_visit = notice_visit;
	}

	@Override
	public String toString() {
		return "NoticeDTO [nbno=" + nbno + ", id=" + id + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_addfile_url=" + notice_addfile_url + ", notice_date=" + notice_date
				+ ", notice_visit=" + notice_visit + "]";
	}
	
	
}
