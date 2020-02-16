package top.auread.entity;

import lombok.Data;

/**
 * 用户收藏表
 * @author Administrator
 *
 */
@Data
public class Collect {

	
	
	
	
	
	
	
	
	
	
	private Integer id;//int  auto_increment primary key comment 'id唯一值',
	private Integer uses_id;// int comment '用户id外键',
	private Integer books_id;// 	int	comment '书籍id,',
	private Integer booksinfo_id;// 	int	comment '观看到第几章节'
	public Collect() {

	}
	public Collect(Integer id, Integer uses_id, Integer books_id, Integer booksinfo_id) {
		this.id = id;
		this.uses_id = uses_id;
		this.books_id = books_id;
		this.booksinfo_id = booksinfo_id;
	}
	
	
	
	
	
	
	
	
}
