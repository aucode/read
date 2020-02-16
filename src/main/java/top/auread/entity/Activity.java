package top.auread.entity;

import lombok.Data;

/**
 * 活动表
 * @author Administrator
 *
 */
@Data
public class Activity {
	
	
	
	private Integer id;// int auto_increment primary key comment 'id唯一值',
	private String activity_title;// varchar(50) comment '活动标题',
	private String activity_ing;// varchar(50) comment '活动滚动图片',
	private String activity_details;//  longtext comment '活动详情'
	public Activity() {

	}
	public Activity(Integer id, String activity_title, String activity_ing, String activity_details) {
		this.id = id;
		this.activity_title = activity_title;
		this.activity_ing = activity_ing;
		this.activity_details = activity_details;
	}
	
	
	
	
	
	
	
	
	
	
}
