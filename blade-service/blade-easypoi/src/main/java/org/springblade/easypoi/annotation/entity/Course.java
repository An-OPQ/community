package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jerry
 */
@Data
@AllArgsConstructor
@TableName("course")
public class Course {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 课程名称
	 */
	@Excel(name = "课程名称", orderNum = "1", width = 15)
	private String name;
	/**
	 * 教师实体
	 */
	private String teacher_id;

}
