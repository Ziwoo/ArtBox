package kr.spring.event.domain;

import java.io.IOException;
import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class EventCommand {
	private int ev_num;
	@NotEmpty
	private String ev_title;
	@NotEmpty
	private String ev_content;
	private Date ev_regdate;
	private MultipartFile upload;
	private byte[] uploadfile;
	private String filename;
	@NotEmpty
	private String mem_id;
	public int getEv_num() {
		return ev_num;
	}
	public void setEv_num(int ev_num) {
		this.ev_num = ev_num;
	}
	public String getEv_title() {
		return ev_title;
	}
	public void setEv_title(String ev_title) {
		this.ev_title = ev_title;
	}
	public String getEv_content() {
		return ev_content;
	}
	public void setEv_content(String ev_content) {
		this.ev_content = ev_content;
	}
	public Date getEv_regdate() {
		return ev_regdate;
	}
	public void setEv_regdate(Date ev_regdate) {
		this.ev_regdate = ev_regdate;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;

		setUploadfile(upload.getBytes());

		setFilename(upload.getOriginalFilename());
			
			
	}
	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "EventCommand [ev_num=" + ev_num + ", ev_title=" + ev_title + ", ev_content=" + ev_content
				+ ", ev_regdate=" + ev_regdate + ", upload=" + upload + ", filename=" + filename + ", mem_id=" + mem_id
				+ "]";
	}
	
	
	
	
	
	}

	
