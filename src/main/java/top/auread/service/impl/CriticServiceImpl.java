package top.auread.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.auread.common.HigherReaponse;
import top.auread.dao.CriticDao;
import top.auread.entity.Critic;
import top.auread.entity.Users;
import top.auread.service.CriticService;

@Service
public class CriticServiceImpl implements CriticService {

	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private CriticDao criticDao;
	
	@Override
	public HigherReaponse<Object> addCritic(Critic critic,HttpServletRequest request) {

		if(null == criticDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		HttpSession session = request.getSession();
		System.out.println("session值："+session);
		Users attribute = (Users) session.getAttribute("user");
		System.out.println("保存用户："+attribute);
		if(null == attribute) {
			return HigherReaponse.getHigherReaponseFailed("未登录。");
		}
		critic.setUser_id(attribute.getUses_id());
		if(null == critic) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		Boolean addGlanceover = criticDao.addCritic(critic);
		
		if(false == addGlanceover) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}
		
		return HigherReaponse.getHigherReaponseSuccess("添加成功");
	}

	@Override
	public HigherReaponse<Critic> selectbydebateid(Critic critic) {
		if(null == criticDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == critic) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		List<Critic> selectbydebateid = criticDao.selectbydebateid(critic);
		if(null == selectbydebateid) {
			return HigherReaponse.getHigherReaponseFailed("无数据。。。");
		}
		
		return HigherReaponse.getHigherReaponseSuccess(selectbydebateid);
	}

}
