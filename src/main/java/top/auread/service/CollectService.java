package top.auread.service;


import javax.servlet.http.HttpServletRequest;

import top.auread.common.HigherReaponse;
import top.auread.entity.Collect;

/**
 * Collect 
 * @author Administrator
 *
 */
public interface CollectService {

	
	
	
	
	//1.分页查找全部数据 
	HigherReaponse<Collect> getListCollect(Integer pageNum, Integer pageSize);
	//2.分页根据用户id查找
	HigherReaponse<Collect> getListCollectByUserid(int id,Integer pageNum, Integer pageSize);
	//3.分页根据书籍id查找
	HigherReaponse<Collect> getListCollectByBooksid(int id,Integer pageNum, Integer pageSize);
	//4.添加一条记录 
	HigherReaponse<Object> addCollect(Collect collect,HttpServletRequest request);
	//5.删除一条记录 
	HigherReaponse<Object> deleteCollect(Collect collect);
	
	
	//6.根据用户id、书籍id查看
	HigherReaponse<Collect> collect_byuidandbookid(Collect collect);
	//6.更新
	HigherReaponse<Object> collect_update(Collect collect);

}
