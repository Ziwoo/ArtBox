package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberDetailAdminController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/member/detail.do")
	public ModelAndView process(HttpSession session){
		
		String mem_id = (String)session.getAttribute("userId");
		
		MemberCommand member = memberService.getMember(mem_id);
		
		if(log.isDebugEnabled()){
			log.debug("member : "+member);
		}
		
		return new ModelAndView("memberDetailAdmin","member",member);
	}
	
}
