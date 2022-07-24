package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author jerry
 */
@Data
@TableName("course")
public class Course {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 课程名称
	 */
	@Excel(name = "课程名称", orderNum = "1", width = 15,needMerge = true)
	private String name;
	/**
	 * 教师实体
	 */
	@ExcelEntity(id = "absent")
	private Teacher teacher;
	/**
	 * 学生实体
	 */
	@ExcelCollection(name = "学生",orderNum = "2")
	private List<Student> students;

}
