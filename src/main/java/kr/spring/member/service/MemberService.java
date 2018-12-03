package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.domain.MemberCommand;


@Transactional
public interface MemberService {
	
	@Transactional(readOnly=true)
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	
	@Transactional(readOnly=true)
	public int getMemberCount();
	
	public void insertMember(MemberCommand member);
	
	@Transactional(readOnly=true)
	public MemberCommand getMember(String mem_id);

	public void updateMember(MemberCommand member);

	public void deleteMember(String mem_id);

}
