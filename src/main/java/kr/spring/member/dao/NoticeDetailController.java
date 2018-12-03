package kr.spring.member.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;

@Controller
public class NoticeDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/detail.do")
	public ModelAndView process(@RequestParam("no_num") int no_num){
		
		if(log.isDebugEnabled()){
			log.debug("no_num : " + no_num);
		}
		
	
		
		NoticeCommand notice = noticeService.selectNotice(no_num);
		return new ModelAndView("noticeView","notice", notice);
	}
	
	//파일 다운로드
	@RequestMapping("/notice/file.do")
	public ModelAndView download(@RequestParam("no_num") int no_num){
		NoticeCommand notice = noticeService.selectNotice(no_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",notice.getUploadfile());
		mav.addObject("filename",notice.getFilename());
		
		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/notice/uploadImageView.do")
	public ModelAndView viewImage(@RequestParam("no_num") int no_num){
		NoticeCommand notice = noticeService.selectNotice(no_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("downloadFile",notice.getUploadfile());
		mav.addObject("filename",notice.getFilename());
		
		return mav;
	}
	
}
