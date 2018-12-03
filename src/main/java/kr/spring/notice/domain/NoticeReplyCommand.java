package kr.spring.notice.domain;

import kr.spring.util.DurationFromNow;

public class NoticeReplyCommand {
	private int re_no;
	private String re_content;
	private String re_date;
	private int no_num;
	private String mem_id;
	
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = DurationFromNow.getTimeDiffLabel(re_date);
 
	}
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id; 
	}
	
	
	@Override
	public String toString() {
		return "NoticeReplyCommand [re_no=" + re_no + ", re_content=" + re_content + ", re_date=" + re_date
				+ ", no_num=" + no_num + ", mem_id=" + mem_id + "]";
	}
	
	
	
	
	
	}
		

