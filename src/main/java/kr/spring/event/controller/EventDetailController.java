package kr.spring.event.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;

@Controller
public class EventDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/event/detail.do")
	public ModelAndView process(@RequestParam("ev_num") int ev_num){
		
		if(log.isDebugEnabled()){
			log.debug("ev_num : " + ev_num);
		} 
		
	
		
		EventCommand event = eventService.selectEvent(ev_num);
		return new ModelAndView("eventView","event", event);
	}
	
	//파일 다운로드
	@RequestMapping("/event/file.do")
	public ModelAndView download(@RequestParam("ev_num") int ev_num){
		EventCommand event = eventService.selectEvent(ev_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",event.getUploadfile());
		mav.addObject("filename",event.getFilename());
		
		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/event/uploadImageView.do")
	public ModelAndView viewImage(@RequestParam("ev_num") int ev_num){
		EventCommand event = eventService.selectEvent(ev_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("downloadFile",event.getUploadfile());
		mav.addObject("filename",event.getFilename());
		
		return mav;
	}
	
}
