package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.LoginCommand;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberLoginController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("command")
	public LoginCommand initCommand(){
		return new LoginCommand();
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String form(){
		return "memberLogin";
	}
	
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid LoginCommand loginCommand,
						 BindingResult result,
						 HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("loginCommand : "+loginCommand);
		}
		
		if(result.hasErrors()){
			return form();
		}
		
		//�α��� üũ(id �Ǵ� ��й�ȣ ��ġ ���� üũ)
		try{
			MemberCommand member = memberService.getMember(loginCommand.getMem_id());
			
			boolean check = false;
			
			if(member != null){
				//��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(loginCommand.getMem_pwd());
			}
			
			if(check){
				//���� ����, �α��� ó��
				session.setAttribute("userId", loginCommand.getMem_id());
				
				return "redirect:/main/main.do";
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			//���� ���з� �� ȣ��
			result.reject("invalidIdOrPassword");
			return form();
		}
		
		
		
		
	}
	
	
}
