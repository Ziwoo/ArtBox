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
public class MemberDeleteUserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		
		String mem_id = (String)session.getAttribute("userId");
		MemberCommand member = new MemberCommand();
		member.setMem_id(mem_id);
		
		model.addAttribute("command",member);
		
		return "memberDeleteUser";
	}
	
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand,
						 BindingResult result,
						 SessionStatus status,
						 HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("memberCommand : "+memberCommand);
		}
		
		//��ȿ��üũ(pwd �ʵ��� ������ üũ)
		if(result.hasFieldErrors("mem_pwd")){
			return "memberDeleteUser";
		}
		
		try{
			MemberCommand member = memberService.getMember(memberCommand.getMem_id());
			
			boolean check = false;
			
			if(member != null){
				//��й�ȣ üũ
				check = member.isCheckedPasswd(memberCommand.getMem_pwd());
			}
			
			if(check){
				//���� ����, ȸ������ ����
				memberService.deleteMember(memberCommand.getMem_id());
				//Session�� ����� Model�� ����
				status.setComplete();
				//�α׾ƿ�
				session.invalidate();
				
				return "redirect:/main/main.do";
			}else{
				//���� ����
				throw new Exception();
			}
		}catch(Exception e){
			result.rejectValue("mem_pwd", "invalidPassword");
			return "memberDeleteUser";
		}
		
		
	}
	
}
