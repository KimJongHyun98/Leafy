package com.plant.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("pbfile")
public class PBFileDTO {
	private int pb_fno;
	private int pb_no;
	private String path;
	private String fileName;
	private String type;
	private String originalFileName;
	
	public PBFileDTO() {
	}
	
	public PBFileDTO(File file) {
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()) {
		case "png":
		case "bmp":
		case "jpg":
		case "gif":
			type = "image";
			break;
		default :
			type = "normal";
		}
	}

	public int getPb_fno() {
		return pb_fno;
	}

	public void setPb_fno(int pb_fno) {
		this.pb_fno = pb_fno;
	}

	public int getPb_no() {
		return pb_no;
	}

	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
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

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	@Override
	public String toString() {
		return "PBFileDTO [pb_fno=" + pb_fno + ", pb_no=" + pb_no + ", path=" + path + ", fileName=" + fileName
				+ ", type=" + type + ", originalFileName=" + originalFileName + "]";
	}

	
}
