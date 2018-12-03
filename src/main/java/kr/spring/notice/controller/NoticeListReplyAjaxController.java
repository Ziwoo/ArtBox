package kr.spring.notice.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.notice.domain.NoticeReplyCommand;
import kr.spring.notice.service.NoticeService;
import kr.spring.util.PagingUtil;
@Controller
public class NoticeListReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/listReplyAjax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam(value="pageNum",defaultValue="1")
										int currentPage,
										@RequestParam("no_num") int no_num){
				
			if(log.isDebugEnabled()){
				log.debug("currentPage : " + currentPage);
				log.debug("no_num : " + no_num);
			}
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("no_num", no_num);
			
			//ÃÑ ±ÛÀÇ °¹¼ö
			int count = noticeService.getRowCountReply(map);
			
			PagingUtil page = new PagingUtil(currentPage,count, rowCount, pageCount, "listReplyAjax.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<NoticeReplyCommand> list = null;
			if(count > 0){
				list = noticeService.listReply(map);
			}else{
				list = Collections.emptyList();
			}
			
			Map<String,Object> mapJson = new HashMap<String, Object>();
			mapJson.put("count", count);
			mapJson.put("rowCount", rowCount);
			mapJson.put("list", list);
						 
			return mapJson;
	
	}
}
