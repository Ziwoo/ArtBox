package kr.spring.notice.service;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.domain.NoticeReplyCommand;


@Transactional
public interface NoticeService {
	//�θ��
	@Transactional(readOnly=true)
	public List<NoticeCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(NoticeCommand notice);
	 
	 
	@Transactional(readOnly=true)
	public NoticeCommand selectNotice(Integer no_num);
	
	public void update(NoticeCommand notice);
	public void delete(Integer no_num);
	
	//���
	@Transactional(readOnly=true)
	public List<NoticeReplyCommand> listReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(NoticeReplyCommand noticeReply);
	public void updateReply(NoticeReplyCommand noticeReply);
	public void deleteReply(Integer re_no);
	
	 
/*	
	@Transactional(readOnly=true)
	public BoardCommand selectBoard(Integer seq);
	public void updateHit(Integer seq);
	public void update(BoardCommand board);
	public void delete(Integer seq);
	
	//���
	@Transactional(readOnly=true)
	public List<BoardReplyCommand> listReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(BoardReplyCommand boardReply);
	public void updateReply(BoardReplyCommand boardReply);
	public void deleteReply(Integer re_no);*/
	
}
