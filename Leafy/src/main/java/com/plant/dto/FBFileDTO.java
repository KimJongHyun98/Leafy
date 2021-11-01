package com.plant.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("fbfile")
public class FBFileDTO {
	private int fb_fno;
	private int fb_no;
	private String path;
	private String fileName;
	private String type;
	private String originalFileName;
	
	public FBFileDTO() {
	}
	
	public FBFileDTO(File file) {
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

	public int getFb_fno() {
		return fb_fno;
	}

	public void setFb_fno(int fb_fno) {
		this.fb_fno = fb_fno;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
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
		return "FBFileDTO [fb_fno=" + fb_fno + ", fb_no=" + fb_no + ", path=" + path + ", fileName=" + fileName
				+ ", type=" + type + ", originalFileName=" + originalFileName + "]";
	}
}
