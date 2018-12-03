package kr.spring.notice.controller;

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

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;

@Controller
@SessionAttributes("command")
public class NoticeUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("no_num") int no_num, Model model){
		
		NoticeCommand noticeCommand = noticeService.selectNotice(no_num);
		
		model.addAttribute("command",noticeCommand);
		
		return "noticeModify";
		
	}
	
	@RequestMapping(value="/notice/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
							@Valid NoticeCommand noticeCommand,
							BindingResult result,
							SessionStatus status,
							HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("noticeCommand : " + noticeCommand);
		}
		
		//작성자의 글을 수정하는지 여부 체크
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(noticeCommand.getMem_id())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 수정할 수 없습니다.");
		}
		
		if(result.hasErrors()){
			return "noticeModify";
		}
		
		NoticeCommand notice = noticeService.selectNotice(noticeCommand.getNo_num());
		if(noticeCommand.getUpload().isEmpty()){
			//전송된 파일이 없을 경우 기존 파일로 셋팅
			noticeCommand.setUploadfile(notice.getUploadfile());
			//전송된 파일이 없을 경우 기존 파일명으로 셋팅
			noticeCommand.setFilename(notice.getFilename());
		}
		
		//글수정
		noticeService.update(noticeCommand);
		status.setComplete();
		
		return "redirect:/notice/noticeList.do";
	}
}
