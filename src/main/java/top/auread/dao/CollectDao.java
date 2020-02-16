package top.auread.dao;
/***
 * Collect 收藏Dao类
 * @author Administrator
 *
 */

import java.util.List;

import top.auread.entity.Collect;

public interface CollectDao {

	
	
	
	
	//1.查找全部数据
	List<Collect> getAllCollect();
	//2.根据用户id查找
	List<Collect> getCollectByUserid(int id);
	//3.根据书籍id查找
	List<Collect> getCollectByBooksid(int id);
	//4.添加一条记录 
	Boolean addCollect(Collect collect);
	//5.删除一条记录 
	Boolean deleteCollect(Collect collect);
	//6.根据id查找 
	int getCollectByid(int id);
	//6.根据用户id、书籍id查看
	Collect collect_byuidandbookid(Collect collect);
	//6.更新
	Boolean collect_update(Collect collect);
}
