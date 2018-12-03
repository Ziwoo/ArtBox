package kr.spring.member.dao;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;

@Controller
public class NoticeDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/delete.do")
	public String submit(@RequestParam("no_num") int no_num,
						HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seg : " + no_num);
		}
		
		NoticeCommand noticeCommand = noticeService.selectNotice(no_num);
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(noticeCommand.getMem_id())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		noticeService.delete(noticeCommand.getNo_num());
		
		return "redirect:/notice/noticeList.do";
		
	}
}
