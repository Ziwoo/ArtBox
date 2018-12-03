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
		
		//�ۼ����� ���� �����ϴ��� ���� üũ
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(eventCommand.getMem_id())){
			throw new Exception("�α����� ���̵�� �ۼ��� ���� �ƴϱ� ������ ������ �� �����ϴ�.");
		}
		
		if(result.hasErrors()){
			return "eventModify";
		}
		
		EventCommand event = eventService.selectEvent(eventCommand.getEv_num());
		if(eventCommand.getUpload().isEmpty()){
			//���۵� ������ ���� ��� ���� ���Ϸ� ����
			eventCommand.setUploadfile(event.getUploadfile());
			//���۵� ������ ���� ��� ���� ���ϸ����� ����
			eventCommand.setFilename(event.getFilename());
		}
		
		//�ۼ���
		eventService.update(eventCommand);
		status.setComplete();
		
		return "redirect:/event/eventList.do";
	}
}
