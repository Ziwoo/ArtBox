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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;

@Controller
@SessionAttributes("command")
public class EventWriteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping(value="/event/eventWrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		String id = (String)session.getAttribute("userId");
		
		EventCommand command = new EventCommand();
		command.setMem_id(id);
		model.addAttribute("command",command);
		
		return "eventWrite";
	}
	
	@RequestMapping(value="/event/eventWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
							@Valid EventCommand eventCommand,
							BindingResult result,
							SessionStatus status){
		
		
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		if(result.hasErrors()){
			return "eventWrite";

		}
		
		//±Û¾²±â
		eventService.insert(eventCommand);
		status.setComplete();	 	
		
		return "redirect:/event/eventList.do";
	}
}
