package top.auread.service;

import top.auread.common.HigherReaponse;
import top.auread.entity.Booksinfo;
import top.auread.entity.Glanceover;

public interface GlanceoverService {


	HigherReaponse<Object> addGlanceover(Glanceover glanceover);
	//根据用户和书籍ID，查找最新一条，显示小说章节表的标题
	HigherReaponse<Booksinfo> selectGlantitle(Glanceover glanceover);
	
}
