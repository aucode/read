package top.auread.dao;


import top.auread.entity.Booksinfo;
import top.auread.entity.Glanceover;

public interface GlanceoverDao {
	Boolean addGlanceover(Glanceover glanceover);
	//根据用户和书籍ID，查找最新一条，显示小说章节表的标题
	Booksinfo selectGlantitle(Glanceover glanceover);
}
