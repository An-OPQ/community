package org.springblade.easypoi.annotation.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springblade.easypoi.annotation.entity.Course;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 注解导出 Excel
 * @author jerry
 */
@RestController
@RequestMapping("/annotationExcel")
public class AnnotationExcel {

	@Resource
	private QuestionService questionService;
	@Resource
	private CourseService courseService;

	/**
	 * 对象定义导出
	 */
	@GetMapping("/objectExport")
	public void objectExport1() throws Exception {
		List<Question> list = questionService.findAll();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("帖子列表", "帖子详情"), Question.class, list);
		FileOutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath()+"/objectExport.xlsx");
		workbook.write(fos);
		fos.close();
	}

	/**
	 * 集合类型的导出
	 */
	@GetMapping("/collectionExport")
	public void collectionExport() throws Exception {
		List<Course> all = courseService.findAll();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("课程信息", "课程信息"), Course.class, all);
		FileOutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath()+"/collectionExport.xlsx");
		workbook.write(fos);
		fos.close();
	}


}
