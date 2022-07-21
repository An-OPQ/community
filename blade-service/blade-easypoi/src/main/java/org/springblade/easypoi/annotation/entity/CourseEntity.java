package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseEntity {
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
	@ExcelEntity(id = "absent")
	private TeacherEntity teacherEntity;

	/**
	 * 学生集合
	 */
	private List<StudentEntity> studentEntities;
}
