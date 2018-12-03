package kr.spring.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberCommand {
	
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String mem_name;
	@Size(min=10,max=15)
	private String mem_pwd;
	@NotEmpty
	private String mem_phone1;
	@NotEmpty
	private String mem_phone2;
	@NotEmpty
	private String mem_phone3;
	@NotEmpty
	private String mem_sex;
	
	@NotEmpty
	private String mem_email1;
	
	@NotEmpty
	private String mem_email2;
	
	private Date mem_regdate;
	
	private String mem_level;
	
	//비밀번호 일치 여부 체크
	public boolean isCheckedPasswd(String userPasswd){
		if(mem_pwd.equals(userPasswd)){
			return true;
		}
		return false;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_phone1() {
		return mem_phone1;
	}
	public void setMem_phone1(String mem_phone1) {
		this.mem_phone1 = mem_phone1;
	}
	public String getMem_phone2() {
		return mem_phone2;
	}
	public void setMem_phone2(String mem_phone2) {
		this.mem_phone2 = mem_phone2;
	}
	public String getMem_phone3() {
		return mem_phone3;
	}
	public void setMem_phone3(String mem_phone3) {
		this.mem_phone3 = mem_phone3;
	}
	public String getMem_sex() {
		return mem_sex;
	}
	public void setMem_sex(String mem_sex) {
		this.mem_sex = mem_sex;
	}
	public String getMem_email1() {
		return mem_email1;
	}
	public void setMem_email1(String mem_email1) {
		this.mem_email1 = mem_email1;
	}
	public String getMem_email2() {
		return mem_email2;
	}
	public void setMem_email2(String mem_email2) {
		this.mem_email2 = mem_email2;
	}
	public Date getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	public String getMem_level() {
		return mem_level;
	}
	public void setMem_level(String mem_level) {
		this.mem_level = mem_level;
	}
	
	@Override
	public String toString() {
		return "MemberCommand [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pwd=" + mem_pwd + ", mem_phone1="
				+ mem_phone1 + ", mem_phone2=" + mem_phone2 + ", mem_phone3=" + mem_phone3 + ", mem_sex=" + mem_sex
				+ ", mem_email1=" + mem_email1 + ", mem_email2=" + mem_email2 + ", mem_regdate=" + mem_regdate
				+ ", mem_level=" + mem_level + "]";
	}
	
	
}
