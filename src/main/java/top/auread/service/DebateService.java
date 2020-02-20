package top.auread.service;

import top.auread.common.HigherReaponse;
import top.auread.entity.Debate;

public interface DebateService {
	
	HigherReaponse<Object> updateDebate();
	
	HigherReaponse<Debate> getDebatesAll();

}
