package com.plant.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("tFile")
public class TFileDTO {
	private int tfno;
	private int tno;
	private String id;
	private String path;
	private String fdate;
	private String originFileName;
	private String fileName;
	private String type;
	
	public TFileDTO() {
	}
	
	public TFileDTO(File file) {
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

	public TFileDTO(int tfno, int tno, String id, String path, String fdate, String originFileName, String fileName,
			String type) {
		super();
		this.tfno = tfno;
		this.tno = tno;
		this.id = id;
		this.path = path;
		this.fdate = fdate;
		this.originFileName = originFileName;
		this.fileName = fileName;
		this.type = type;
	}

	@Override
	public String toString() {
		return "TFileDTO [tfno=" + tfno + ", tno=" + tno + ", id=" + id + ", path=" + path + ", fdate=" + fdate
				+ ", originFileName=" + originFileName + ", fileName=" + fileName + ", type=" + type + "]";
	}

	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
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
	
}
