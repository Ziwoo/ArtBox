package kr.spring.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.domain.NoticeReplyCommand;



@Repository
public interface NoticeMapper {
	//부모글
	public List<NoticeCommand> list(Map<String,Object> map);
	public int getRowCount( Map<String,Object> map);
	
	@Insert("INSERT INTO ab_notice (no_num,no_title,no_content,no_regdate,uploadfile,filename,mem_id) VALUES "
			+ "(notice_board_seq.nextval,#{no_title},#{no_content},sysdate,#{uploadfile,jdbcType=BLOB},#{filename,jdbcType=VARCHAR},#{mem_id})")
	 
	public void insert(NoticeCommand notice); 
	 
	@Select("SELECT * FROM ab_notice WHERE no_num = #{no_num}")
	public NoticeCommand selectNotice(Integer no_num);
	
	@Update("UPDATE ab_notice SET no_title=#{no_title},no_content=#{no_content},uploadfile=#{uploadfile,jdbcType=BLOB},filename=#{filename,jdbcType=VARCHAR} WHERE no_num=#{no_num}")
	public void update(NoticeCommand notice);
	@Delete("DELETE FROM ab_notice WHERE no_num=#{no_num}")
	public void delete(Integer no_num); 
	
	//댓글
	public List<NoticeReplyCommand> listReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM noticereply WHERE no_num=#{no_num}")
	public int getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO noticereply (re_no,re_content,re_date,no_num,mem_id) VALUES (reply_no_num.nextval,#{re_content},sysdate,#{no_num},#{mem_id})")
	public void insertReply(NoticeReplyCommand noticeReply);
	
	@Update("UPDATE noticereply SET re_content=#{re_content}"
			+ "WHERE re_no=#{re_no}")
	public void updateReply(NoticeReplyCommand noticeReply);
	@Delete("DELETE FROM noticereply WHERE re_no=#{re_no}")
	public void deleteReply(Integer re_no); 
	 
	/*@Delete("DELETE FROM noticereply WHERE no_num=#{no_num}")
	public void deleteReplyByNo_num(Integer no_num);*/
	 
	
	/*@Update("UPDATE sboard SET hit = hit+1 WHERE seq = #{seq}")
	public void updateHit(Integer seq);
	@Update("UPDATE sboard SET title=#{title},content=#{content},uploadfile=#{uploadfile,jdbcType=BLOB},filename=#{filename,jdbcType=VARCHAR} WHERE seq=#{seq}")
	public void update(BoardCommand board);
	public void delete(Integer seq);	
	//댓글
	 * 
	
	public List<BoardReplyCommand> listReply(Map<String,Object> map);
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(BoardReplyCommand boardReply);
	public void updateReply(BoardReplyCommand boardReply);
	public void deleteReply(Integer re_no);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	public void deleteReplyBySeq(Integer seq);
	
	//회원탈퇴시 처리사항
	//해당id로 작성된 모든 글의 글번호 구하기
	public List<Integer> selectSeqById(String id);
	//해당 id로 작성된 모든 글에 달린 댓글 삭제
	public void deleteReplyBySeqList(List<Integer> list);
	//해당 id로 작성된 모든 댓글 삭제
	public void deleteReplyById(String id);
	//해당 id로 작성된 모든 부모글 삭제
	public void deleteById(String id);*/
	
}
