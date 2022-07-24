package org.springblade.easypoi.annotation.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jerry
 */
@Data
public class Teacher implements Serializable {
	/**
	 * 主键
	 */
	private String id;
	/** name */
	@Excel(name = "主讲老师_major,代课老师_absent", isImportField = "true_major,true_absent",needMerge = true)
	private String name;
}
