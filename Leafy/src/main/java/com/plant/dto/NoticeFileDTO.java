package com.plant.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("noticefile")
public class NoticeFileDTO {
	private int nfno;
	private int nbno;
	private String id;
	private String path;
	private String fdate;
	private String fileName;
	private String type;
	private String originFileName;
	
	public NoticeFileDTO() {
	}
	
	public NoticeFileDTO(File file) {
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

	public NoticeFileDTO(int nfno, int nbno, String id,  String path,String fdate, String fileName, String type,
			String originFileName) {
		super();
		this.nfno = nfno;
		this.nbno = nbno;
		this.id = id;
		this.path = path;
		this.fdate = fdate;
		this.fileName = fileName;
		this.type = type;
		this.originFileName = originFileName;
	}

	@Override
	public String toString() {
		return "NoticeFileDTO [nfno=" + nfno + ", nbno=" + nbno + ", id=" + id + ", fdate=" + fdate + ", path=" + path
				+ ", fileName=" + fileName + ", type=" + type + "]";
	}

	public int getNfno() {
		return nfno;
	}

	public void setNfno(int nfno) {
		this.nfno = nfno;
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

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
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

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	
}
