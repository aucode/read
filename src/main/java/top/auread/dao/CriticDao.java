package top.auread.dao;

import java.util.List;

import top.auread.entity.Critic;

public interface CriticDao {

	//
	Boolean addCritic(Critic critic);
	
	List<Critic> selectbydebateid(Critic critic);
}
