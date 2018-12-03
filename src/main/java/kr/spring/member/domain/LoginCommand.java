package kr.spring.member.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginCommand {
	
	@NotEmpty
	private String mem_id;
	@Size(min=10,max=15)
	private String mem_pwd;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	
	@Override
	public String toString() {
		return "LoginCommand [mem_id=" + mem_id + ", mem_pwd=" + mem_pwd + "]";
	}
	
	
}
