package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.notice.dao.NoticeMapper;
import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.domain.NoticeReplyCommand;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;
      
	@Override
	public List<NoticeCommand> list(Map<String, Object> map) {
		return noticeMapper.list(map);
	}  
  
	@Override
	public int getRowCount(Map<String, Object> map) {
		return noticeMapper.getRowCount(map);
	}

	@Override
	public void insert(NoticeCommand notice) {
		noticeMapper.insert(notice);
	}

	@Override
	public NoticeCommand selectNotice(Integer no_num) {
		return noticeMapper.selectNotice(no_num);
	}
	
	@Override
	public void update(NoticeCommand notice) {
		noticeMapper.update(notice);
	}

	@Override
	public void delete(Integer no_num) {
		//부모글 삭제 
		/*noticeMapper.deleteReplyByNo_num(no_num);
		*/
		noticeMapper.delete(no_num);
	}
	
	@Override
	public List<NoticeReplyCommand> listReply(Map<String, Object> map) {
		return noticeMapper.listReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return noticeMapper.getRowCount(map);
	}
	
	@Override
	public void insertReply(NoticeReplyCommand noticeReply) {
		noticeMapper.insertReply(noticeReply);
	}
	
	@Override
	public void updateReply(NoticeReplyCommand noticeReply) {
		noticeMapper.updateReply(noticeReply);
	} 

	@Override
	public void deleteReply(Integer re_no) {
		noticeMapper.deleteReply(re_no);
	} 
	
	
	
	
	

}
