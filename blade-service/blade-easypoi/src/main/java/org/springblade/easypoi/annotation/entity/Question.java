package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Community-帖子问题表
 * @author jerry
 */
@Data
@ExcelTarget("question")
@TableName("question")
public class Question implements Serializable {
	/**
	 * id
	 */
	private Long id;
	/**
	 * 文章标题
	 */
	@Excel(name = "文章标题",width = 30)
	private String title;
	/**
	 * 文章详情
	 */
	@Excel(name = "文章详情",width = 60)
	private String description;
	/**
	 * 创建者id
	 */
	@ExcelIgnore
	private Long creatorid;
	/**
	 * 文章类型ID
	 */
	@Excel(name = "文章类型",width = 10)
	private Integer typeid;
	/**
	 * 评论数量
	 */
	@Excel(name = "评论数量",width = 10)
	private Integer commentCount;
	/**
	 * 阅读数量
	 */
	@Excel(name = "阅读数量",width = 20)
	private Integer viewCount;
	/**
	 * 点赞数量
	 */
	@Excel(name = "点赞数量",width = 20)
	private Integer likeCount;
	/**
	 * 创建时间
	 */
	@Excel(name = "创建时间",width = 20)
	private LocalDateTime createDate;
}
