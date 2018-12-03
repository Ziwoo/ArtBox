package kr.spring.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.notice.domain.NoticeReplyCommand;
import kr.spring.notice.service.NoticeService;

@Controller
public class NoticeWriteReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/writeReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
			             NoticeReplyCommand noticeReplyCommand,
			             HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("noticeReplyCommand : " + noticeReplyCommand);
		}
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId==null){//·Î±×ÀÎ ¾ÈµÊ
				map.put("result", "logout");
			}else{//·Î±×ÀÎ µÊ,´ñ±Û µî·Ï
				noticeService.insertReply(noticeReplyCommand);
				map.put("result", "success");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
}