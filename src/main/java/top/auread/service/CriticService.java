package top.auread.service;


import javax.servlet.http.HttpServletRequest;

import top.auread.common.HigherReaponse;
import top.auread.entity.Critic;

public interface CriticService {

	HigherReaponse<Object> addCritic(Critic critic,HttpServletRequest request);

	HigherReaponse<Critic> selectbydebateid(Critic critic);
}
