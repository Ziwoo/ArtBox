package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;
import kr.spring.notice.dao.NoticeMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource
	private MemberMapper memberMapper;
	
	@Resource
	private NoticeMapper noticeMapper;
	
	
	@Override
	public List<MemberCommand> getMemberList(Map<String, Object> map) {
		return memberMapper.getMemberList(map);
	}

	@Override
	public int getMemberCount() {
		return memberMapper.getMemberCount();
	}

	@Override
	public void insertMember(MemberCommand member) {
		memberMapper.insertMember(member);
	}

	@Override
	public MemberCommand getMember(String mem_id) {
		return memberMapper.getMember(mem_id);
	}

	@Override
	public void updateMember(MemberCommand member) {
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(String mem_id) {
		memberMapper.deleteMember(mem_id);		
	}

}
