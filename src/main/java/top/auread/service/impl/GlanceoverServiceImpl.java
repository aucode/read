package top.auread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.auread.common.HigherReaponse;
import top.auread.dao.GlanceoverDao;
import top.auread.entity.Booksinfo;
import top.auread.entity.Glanceover;
import top.auread.service.GlanceoverService;

@Service
public class GlanceoverServiceImpl implements GlanceoverService {

	
	@Autowired //注解  @Autowired 再容器里自动找UserDao对象
	private GlanceoverDao glanceoverDao;
	
	@Override
	public HigherReaponse<Object> addGlanceover(Glanceover glanceover) {

		
		if(null == glanceoverDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == glanceover) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		Boolean addGlanceover = glanceoverDao.addGlanceover(glanceover);
		System.out.println(addGlanceover);
		if(false == addGlanceover) {
			return HigherReaponse.getHigherReaponseFailed("添加失败。。。");
		}
		
		return HigherReaponse.getHigherReaponseSuccess("添加成功");
	}

	@Override
	public HigherReaponse<Booksinfo> selectGlantitle(Glanceover glanceover) {

		if(null == glanceoverDao) {
			return HigherReaponse.getHigherReaponseFailed("服务器异常。。。");
		}
		if(null == glanceover) {
			return HigherReaponse.getHigherReaponseFailed("数据错误。。。");
		}
		Booksinfo selectGlantitle = glanceoverDao.selectGlantitle(glanceover);
		if(null == selectGlantitle) {
			return HigherReaponse.getHigherReaponseFailed("无数据。。。");
		}
		
		return HigherReaponse.getHigherReaponseSuccess(selectGlantitle);
	}



}
