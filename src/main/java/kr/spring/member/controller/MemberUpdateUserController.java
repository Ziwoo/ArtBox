package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
@SessionAttributes("command")
public class MemberUpdateUserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		
		String mem_id = (String)session.getAttribute("userId");
		
		MemberCommand member = memberService.getMember(mem_id);
		//�𵨿� ����� ������ @SessionAttribute("command")�� ����
		//���ǿ� ����
		model.addAttribute("command",member);
		
		return "memberModifyUser";		
	}
	
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand,
						 BindingResult result,
						 SessionStatus status){
		if(log.isDebugEnabled()){
			log.debug("memberCommand : "+memberCommand);
		}
		
		//��ȿ��üũ
		if(result.hasErrors()){
			return "memberModifyUser";
		}
		
		//ȸ����������
		memberService.updateMember(memberCommand);
		//Session�� ����� model�� �����ϴ� �̺�Ʈ
		status.setComplete();
		
		return "redirect:/member/detail.do";
	}
	
	
}
