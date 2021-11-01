package com.plant.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("mtmfile")
public class MTMFileDTO {
	private int fno;
	private int mno;
	private String id;
	private String fdate;
	private String path;
	private String fileName;
	private String type;
	private String originFileName;
	
	public MTMFileDTO() {
	}
	
	public MTMFileDTO(File file) {
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		switch (fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase()) {
		case "png":
		case "bmp":
		case "jpg":
		case "gif":
			type = "image";
			break;
		default:
			type = "normal";
		}
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}


	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public int getFileNo() {
		return fno;
	}

	public void setFileNo(int fileNo) {
		this.fno = fileNo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MTMFileDTO [fno=" + fno + ", mno=" + mno + ", id=" + id + ", fdate=" + fdate + ", path=" + path
				+ ", fileName=" + fileName + ", type=" + type + "]";
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	

}