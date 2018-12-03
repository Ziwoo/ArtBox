package kr.spring.event.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import kr.spring.event.domain.EventCommand;
import kr.spring.event.dao.EventMapper;

 
@Service("eventService")
public class EventServiceImpl implements EventService {

	@Resource
	private EventMapper eventMapper;

	@Override
	public List<EventCommand> list(Map<String, Object> map) {
		return eventMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return eventMapper.getRowCount(map);
	}

	@Override
	public void insert(EventCommand event) {
		eventMapper.insert(event);
	}

	@Override
	public EventCommand selectEvent(Integer ev_num) {
		return eventMapper.selectEvent(ev_num); 
	}

	@Override
	public void update(EventCommand event) {
		eventMapper.update(event);
	}

	@Override
	public void delete(Integer ev_num) {
		eventMapper.delete(ev_num);
	}

	
	
	
	
	
	
	

}
