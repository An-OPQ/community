package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
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
public class Images implements Serializable {

	private String id;
	@Excel(name = "名称", orderNum = "1")
	private String name;
	@Excel(name = "图片", type = 2, imageType = 1, orderNum = "2")
	private String urlPath;
	@Excel(name = "图片地址2", type = 2, imageType = 2, orderNum = "3")
	@ExcelIgnore
	private char[] urlPath2;
	@Excel(name = "备注", orderNum = "4")
	private String remark;
}
