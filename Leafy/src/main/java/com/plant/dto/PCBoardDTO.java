package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("pcBoard")
public class PCBoardDTO {
	private int pcbno;
	private String id;
	private String pcb_title;
	private String plant_name;
	private int price;
	private String pcb_content;
	private String pcb_addfile_url;
	private int trade_status;
	private int pcb_recommand;
	private int pcb_visit;
	
	public PCBoardDTO() {
	}

	public PCBoardDTO(int pcbno, String id, String pcb_title, String plant_name, int price, String pcb_content,
			String pcb_addfile_url, int trade_status, int pcb_recommand, int pcb_visit) {
		super();
		this.pcbno = pcbno;
		this.id = id;
		this.pcb_title = pcb_title;
		this.plant_name = plant_name;
		this.price = price;
		this.pcb_content = pcb_content;
		this.pcb_addfile_url = pcb_addfile_url;
		this.trade_status = trade_status;
		this.pcb_recommand = pcb_recommand;
		this.pcb_visit = pcb_visit;
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

	public String getPcb_title() {
		return pcb_title;
	}

	public void setPcb_title(String pcb_title) {
		this.pcb_title = pcb_title;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcb_content() {
		return pcb_content;
	}

	public void setPcb_content(String pcb_content) {
		this.pcb_content = pcb_content;
	}

	public String getPcb_addfile_url() {
		return pcb_addfile_url;
	}

	public void setPcb_addfile_url(String pcb_addfile_url) {
		this.pcb_addfile_url = pcb_addfile_url;
	}

	public int getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(int trade_status) {
		this.trade_status = trade_status;
	}

	public int getPcb_recommand() {
		return pcb_recommand;
	}

	public void setPcb_recommand(int pcb_recommand) {
		this.pcb_recommand = pcb_recommand;
	}

	public int getPcb_visit() {
		return pcb_visit;
	}

	public void setPcb_visit(int pcb_visit) {
		this.pcb_visit = pcb_visit;
	}

	@Override
	public String toString() {
		return "PCBoardDTO [pcbno=" + pcbno + ", id=" + id + ", pcb_title=" + pcb_title + ", plant_name=" + plant_name
				+ ", price=" + price + ", pcb_content=" + pcb_content + ", pcb_addfile_url=" + pcb_addfile_url
				+ ", trade_status=" + trade_status + ", pcb_recommand=" + pcb_recommand + ", pcb_visit=" + pcb_visit
				+ "]";
	}
	
}
