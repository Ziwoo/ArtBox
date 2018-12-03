package kr.spring.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;
import kr.spring.util.PagingUtil;

@Controller
public class NoticeListController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 5;
	private int pageCount = 5; 
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/noticeList.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = noticeService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount, "noticeList.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<NoticeCommand> list = null;
		if(count > 0){
			list = noticeService.list(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("noticeList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav; 
	}
}
