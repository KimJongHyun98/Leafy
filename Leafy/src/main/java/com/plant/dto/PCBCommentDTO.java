package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("pcbComment") // 생육게시판 댓글 DTO
public class PCBCommentDTO {
	private int pcbno;
	private String id;
	private String pcb_comment_content;
	private String pcb_comment_date;
	private int pcb_comment_like;
	
	public PCBCommentDTO() {
		
	}

	public PCBCommentDTO(int pcbno, String id, String pcb_comment_content, String pcb_comment_date, int pcb_comment_like) {
		super();
		this.pcbno = pcbno;
		this.id = id;
		this.pcb_comment_content = pcb_comment_content;
		this.pcb_comment_date = pcb_comment_date;
		this.pcb_comment_like = pcb_comment_like;
	}

	public int getPcbno() {
		return pcbno;
	}

	public void setPcbno(int pcbno) {
		this.pcbno = pcbno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPcb_comment_content() {
		return pcb_comment_content;
	}

	public void setPcb_comment_content(String pcb_comment_content) {
		this.pcb_comment_content = pcb_comment_content;
	}

	public String getPcb_comment_date() {
		return pcb_comment_date;
	}

	public void setPcb_comment_date(String pcb_comment_date) {
		this.pcb_comment_date = pcb_comment_date;
	}

	public int getPcb_comment_like() {
		return pcb_comment_like;
	}

	public void setPcb_comment_like(int pcb_comment_like) {
		this.pcb_comment_like = pcb_comment_like;
	}

	@Override
	public String toString() {
		return "PCBComment [pcbno=" + pcbno + ", id=" + id + ", pcb_comment_content=" + pcb_comment_content
				+ ", pcb_comment_date=" + pcb_comment_date + ", pcb_comment_like=" + pcb_comment_like + "]";
	}
	
}
