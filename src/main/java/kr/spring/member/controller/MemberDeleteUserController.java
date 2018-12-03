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
		
		//유효성체크(pwd 필드의 에러만 체크)
		if(result.hasFieldErrors("mem_pwd")){
			return "memberDeleteUser";
		}
		
		try{
			MemberCommand member = memberService.getMember(memberCommand.getMem_id());
			
			boolean check = false;
			
			if(member != null){
				//비밀번호 체크
				check = member.isCheckedPasswd(memberCommand.getMem_pwd());
			}
			
			if(check){
				//인증 성공, 회원정보 삭제
				memberService.deleteMember(memberCommand.getMem_id());
				//Session에 저장된 Model을 삭제
				status.setComplete();
				//로그아웃
				session.invalidate();
				
				return "redirect:/main/main.do";
			}else{
				//인증 실패
				throw new Exception();
			}
		}catch(Exception e){
			result.rejectValue("mem_pwd", "invalidPassword");
			return "memberDeleteUser";
		}
		
		
	}
	
}
