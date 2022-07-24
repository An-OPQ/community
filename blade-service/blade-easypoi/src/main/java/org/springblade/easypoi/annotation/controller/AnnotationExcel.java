package org.springblade.easypoi.annotation.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springblade.easypoi.annotation.entity.Course;
import org.springblade.easypoi.annotation.entity.Images;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解导出 Excel
 *
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
		FileOutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath() + "/objectExport.xlsx");
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
		FileOutputStream fos = new FileOutputStream(this.getClass().getResource("/").getPath() + "/collectionExport.xlsx");
		workbook.write(fos);
		fos.close();
	}

	/**
	 * 图片类型的导出
	 * 直接使用本地图片与在线图片测试，不连通数据库
	 */
	@GetMapping("/imagesExport")
	public void imagesExport() throws IOException {
		List<Images> imagesList = new ArrayList<>();
		imagesList.add(new Images("1", "测试1", "/home/jerry/Pictures/wallhaven-9m7gl8.png", null, "测试用力1"));
//		imagesList.add(new Images("2", "测试2", "https://th.wallhaven.cc/lg/k7/k7q9m7.jpg", null, "测试用力2"));
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("图片导出", ""), Images.class, imagesList);
		FileOutputStream fileOutputStream = new FileOutputStream(this.getClass().getResource("/").getPath() + "/imagesExport.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}

}
