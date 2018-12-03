package kr.spring.notice.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class NoticeCommand {
	private int no_num;
	@NotEmpty
	private String no_title;
	@NotEmpty
	private String no_content;
	private Date no_regdate;
	private MultipartFile upload;
	private byte[] uploadfile;
	private String filename;
	@NotEmpty
	private String mem_id;
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public Date getNo_regdate() {
		return no_regdate;
	}
	public void setNo_regdate(Date no_regdate) {
		this.no_regdate = no_regdate;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
		
		setUploadfile(upload.getBytes());
		
		setFilename(upload.getOriginalFilename());
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	public byte[] getUploadfile() {
		return uploadfile;
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
		return "NoticeCommand [no_num=" + no_num + ", no_title=" + no_title + ", no_content=" + no_content
				+ ", no_regdate=" + no_regdate + ", upload=" + upload + ", filename=" + filename + ", mem_id=" + mem_id
				+ "]";
	}
	
	
	}
	
	
	
