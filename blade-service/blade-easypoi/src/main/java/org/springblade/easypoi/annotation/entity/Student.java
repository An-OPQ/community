package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * @author jerry
 */
@Data
public class Student implements java.io.Serializable {
	/**
	 * id
	 */
	private String id;
	/**
	 * 学生姓名
	 */
	@Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
	private String name;
	/**
	 * 学生性别
	 */
	@Excel(name = "学生性别", replace = {"男_1", "女_2"}, suffix = "生", isImportField = "true_st")
	private int sex;

	@Excel(name = "出生日期", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
	private Date birthday;

	@Excel(name = "进校日期", format = "yyyy-MM-dd")
	private Date registrationDate;

}