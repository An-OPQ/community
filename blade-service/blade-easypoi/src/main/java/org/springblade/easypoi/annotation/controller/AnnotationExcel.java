package org.springblade.easypoi.annotation.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.easypoi.annotation.entity.Course;
import org.springblade.easypoi.annotation.entity.Images;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.entity.User;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
	@GetMapping("/excelExportByTemplate")
	public void excelExportByTemplate() throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "liuxian");
		map.put("date", String.valueOf(LocalDateTime.now()));
		List<Map<String, String>> maps = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Map<String, String> lm = new HashMap<>();
			lm.put("id", i + 1 + "");
			lm.put("title", i * 10000 + "");
			lm.put("description", "A001");
			lm.put("creatorid","");
			lm.put("typeid", "EasyPoi " + i + "期");
			lm.put("commentCount", "开源项目");
			lm.put("viewCount", i * 10000 + "");
			lm.put("likeCount", i * 10000 + "");
			lm.put("createDate", i * 10000 + "");
			maps.add(lm);
		}
		map.put("mapList",maps);
		TemplateExportParams params = new TemplateExportParams("/home/jerry/Software/javaWorks/community/blade-service/blade-easypoi/src/test/resources/WEB-INF/doc/test2.xls");
		Workbook workbook = ExcelExportUtil.exportExcel(params, map);
		FileOutputStream fileOutputStream = new FileOutputStream(this.getClass().getResource("/").getPath()+"/test.xls");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}

//	@Test
//	public void fe_map() throws Exception {
//		TemplateExportParams params = new TemplateExportParams(
//			"WEB-INF/doc/专项支出用款申请书_map.xls");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("date", "2014-12-25");
//		map.put("money", 2000000.00);
//		map.put("upperMoney", "贰佰万");
//		map.put("company", "执笔潜行科技有限公司");
//		map.put("bureau", "财政局");
//		map.put("person", "JueYue");
//		map.put("phone", "1879740****");
//		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
//		for (int i = 0; i < 4; i++) {
//			Map<String, String> lm = new HashMap<String, String>();
//			lm.put("id", i + 1 + "");
//			lm.put("zijin", i * 10000 + "");
//			lm.put("bianma", "A001");
//			lm.put("mingcheng", "设计");
//			lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
//			lm.put("quancheng", "开源项目");
//			lm.put("sqje", i * 10000 + "");
//			lm.put("hdje", i * 10000 + "");
//
//			listMap.add(lm);
//		}
//		map.put("maplist", listMap);
//
//		Workbook workbook = ExcelExportUtil.exportExcel(params, map);
//		File savefile = new File("/home/jerry/excel/");
//		if (!savefile.exists()) {
//			savefile.mkdirs();
//		}
//		FileOutputStream fos = new FileOutputStream("/home/jerry/excel/专项支出用款申请书_map.xls");
//		workbook.write(fos);
//		fos.close();
//	}
}
