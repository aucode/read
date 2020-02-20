package top.auread.dao;

import java.util.List;

import top.auread.entity.Debate;

public interface DebateDao {

	//更新一条记录 登录记录加一
	Boolean updateDebate();
	//读取所有记录 
	List<Debate> getDebatesAll();
}
