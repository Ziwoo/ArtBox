package kr.spring.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.event.domain.EventCommand;



@Repository
public interface EventMapper {
	//ºÎ¸ð±Û
	public List<EventCommand> list(Map<String,Object> map);
	public int getRowCount( Map<String,Object> map);
	
	@Insert("INSERT INTO ab_event (ev_num,ev_title,ev_content,ev_regdate,uploadfile,filename,mem_id) VALUES "
			+ "(event_board_seq.nextval,#{ev_title},#{ev_content},sysdate,#{uploadfile,jdbcType=BLOB},#{filename,jdbcType=VARCHAR},#{mem_id})")
	public void insert(EventCommand event); 
	@Select("SELECT * FROM ab_event WHERE ev_num = #{ev_num}")
	public EventCommand selectEvent(Integer ev_num);
	@Update("UPDATE ab_event SET ev_title=#{ev_title},ev_content=#{ev_content},uploadfile=#{uploadfile,jdbcType=BLOB},filename=#{filename,jdbcType=VARCHAR} WHERE ev_num=#{ev_num}")
	public void update(EventCommand event);
	@Delete("DELETE FROM ab_event WHERE ev_num=#{ev_num}")
	public void delete(Integer ev_num); 
	
	
	
	
}
