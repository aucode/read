package top.auread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.auread.common.HigherReaponse;
import top.auread.dao.DebateDao;
import top.auread.entity.Debate;
import top.auread.service.DebateService;

@Service
public class DebateServiceImpl implements DebateService {

	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private  DebateDao debateDao;
	
	
	
	
	@Override
	public HigherReaponse<Object> updateDebate() {
		// TODO Auto-generated method stub
		Boolean updateDebate = debateDao.updateDebate();
		if (updateDebate) {
			return HigherReaponse.getHigherReaponseFailed("更新失败。");
		}
		return HigherReaponse.getHigherReaponseSuccess("更新成功");
	}

	@Override
	public HigherReaponse<Debate> getDebatesAll() {
		// TODO Auto-generated method stub
		if(null == debateDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。");
		}
		return HigherReaponse.getHigherReaponseSuccess(debateDao.getDebatesAll());
	}

}
