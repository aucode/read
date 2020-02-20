package top.auread.entity;

import lombok.Data;

@Data
public class Debate {

	
	
	
	private Integer id ;//int  auto_increment primary key comment 'id唯一值',
	private String debate_context;// text comment '几号',
	private Integer debate_count;//  int default 0 comment '浏览次数'
	public Debate(Integer id, String debate_context, Integer debate_count) {
		super();
		this.id = id;
		this.debate_context = debate_context;
		this.debate_count = debate_count;
	}
	public Debate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
