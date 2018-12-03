package kr.spring.event.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;

@Controller
public class EventDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/event/delete.do")
	public String submit(@RequestParam("ev_num") int ev_num,
						HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seg : " + ev_num);
		}
		
		EventCommand eventCommand = eventService.selectEvent(ev_num);
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(eventCommand.getMem_id())){
			throw new Exception("�α����� ���̵�� �ۼ��� ���� �ƴϱ� ������ ������ �� �����ϴ�.");
		}
		
		//�� ����
		eventService.delete(eventCommand.getEv_num());
		
		return "redirect:/event/eventList.do";
		
	}
}
