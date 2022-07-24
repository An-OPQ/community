package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jerry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("user")
public class User implements Serializable {

	@Excel(name = "姓名", width = 30, orderNum = "1")
	private String name;

	@Excel(name = "年龄", width = 10, orderNum = "2")
	private Integer age;

	@Excel(name = "性别", width = 10, orderNum = "3", replace = {"女_0", "男_1"})
	private Integer sex;
}
