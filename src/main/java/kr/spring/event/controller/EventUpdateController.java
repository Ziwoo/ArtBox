package kr.spring.event.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;

@Controller
@SessionAttributes("command")
public class EventUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping(value="/event/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("ev_num") int ev_num, Model model){
		
		EventCommand eventCommand = eventService.selectEvent(ev_num);
		
		model.addAttribute("command",eventCommand);
		
		return "eventModify";
		
	}
	
	@RequestMapping(value="/event/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
							@Valid EventCommand eventCommand,
							BindingResult result,
							SessionStatus status,
							HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		
		//작성자의 글을 수정하는지 여부 체크
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(eventCommand.getMem_id())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 수정할 수 없습니다.");
		}
		
		if(result.hasErrors()){
			return "eventModify";
		}
		
		EventCommand event = eventService.selectEvent(eventCommand.getEv_num());
		if(eventCommand.getUpload().isEmpty()){
			//전송된 파일이 없을 경우 기존 파일로 셋팅
			eventCommand.setUploadfile(event.getUploadfile());
			//전송된 파일이 없을 경우 기존 파일명으로 셋팅
			eventCommand.setFilename(event.getFilename());
		}
		
		//글수정
		eventService.update(eventCommand);
		status.setComplete();
		
		return "redirect:/event/eventList.do";
	}
}
