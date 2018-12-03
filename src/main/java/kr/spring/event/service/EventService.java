package kr.spring.event.service;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.event.domain.EventCommand;


@Transactional
public interface EventService {
	//ºÎ¸ð±Û
	@Transactional(readOnly=true) 
	public List<EventCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(EventCommand event);
	  
	 
	@Transactional(readOnly=true)
	public EventCommand selectEvent(Integer ev_num);
	
	public void update(EventCommand event);
	public void delete(Integer ev_num); 
	
	
	
	 
/*	
	@Transactional(readOnly=true)
	public BoardCommand selectBoard(Integer seq);
	public void updateHit(Integer seq);
	public void update(BoardCommand board);
	public void delete(Integer seq);
	
	//´ñ±Û
	@Transactional(readOnly=true)
	public List<BoardReplyCommand> listReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(BoardReplyCommand boardReply);
	public void updateReply(BoardReplyCommand boardReply);
	public void deleteReply(Integer re_no);*/
	
}
