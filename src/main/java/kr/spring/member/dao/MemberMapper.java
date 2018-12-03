package kr.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.member.domain.MemberCommand;

@Repository
public interface MemberMapper {
	
	//xml
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	public int getMemberCount();
	
	//어노테이션
	@Insert("INSERT INTO ab_member (mem_id,mem_name,mem_pwd,mem_phone1,mem_phone2,mem_phone3,mem_sex,mem_email1,mem_email2,mem_regdate) VALUES (#{mem_id},#{mem_name},#{mem_pwd},#{mem_phone1},#{mem_phone2},#{mem_phone3},#{mem_sex},#{mem_email1},#{mem_email2},sysdate)")
	public void insertMember(MemberCommand member);
	
	@Select("SELECT * FROM ab_member WHERE mem_id=#{mem_id}")
	public MemberCommand getMember(String mem_id);
	
	@Update("UPDATE ab_member SET mem_name=#{mem_name},mem_pwd=#{mem_pwd},mem_phone1=#{mem_phone1},mem_phone2=#{mem_phone2},mem_phone3=#{mem_phone3},mem_sex=#{mem_sex},mem_email1=#{mem_email1},mem_email2=#{mem_email2} WHERE mem_id=#{mem_id}")
	public void updateMember(MemberCommand member);
	
	@Delete("DELETE FROM ab_member WHERE mem_id=#{mem_id}")
	public void deleteMember(String mem_id);
	
	
}
