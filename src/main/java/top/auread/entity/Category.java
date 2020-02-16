package top.auread.entity;

import lombok.Data;

/**
 * //类别实体类
 * @author Administrator
 *
 */
@Data
public class Category {
	  private Integer id;  //auto_increment primary key comment 'id唯一值',
	  private String category_title;// varchar(50) NOT NULL COMMENT '类别名称'
	  
	  
	  
	  public Category() {
		  
	  }
	  
	  
	  
	  
	public Category(Integer id, String category_title) {
		this.id = id;
		this.category_title = category_title;
	}
	  
	  
}
