package org.springblade.easypoi.annotation;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springblade.easypoi.annotation.entity.CourseEntity;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.entity.StudentEntity;
import org.springblade.easypoi.annotation.entity.TeacherEntity;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解导出 Excel
 */
@RestController
@RequestMapping("/annotationExcel")
public class AnnotationExcel {

	@Resource
	private QuestionService questionService;

	/**
	 * 对象定义导出
	 */
	@GetMapping("/objectExport1")
	public void objectExport1() throws Exception {
		List<Question> list = questionService.findAll();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("帖子列表", "帖子详情"), Question.class, list);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Downloads\\objectExport1.xls");
		workbook.write(fos);
		fos.close();
	}

	public void collectionExport() {

	}


}
