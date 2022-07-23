package org.springblade.easypoi;

import org.junit.jupiter.api.Test;
import org.springblade.core.test.BladeBootTest;
import org.springblade.easypoi.annotation.entity.Course;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单元测试
 */
@SpringBootTest(classes = BladeEasyPoiApplication.class)
@BladeBootTest(appName = "blade-EasyPoi", enableLoader = true)
class BladeEasypoiApplicationTests {

	@Resource
	private QuestionService questionService;
	@Resource
	private CourseService courseService;

	/**
	 * 测试多数据源
	 */
	@Test
	void contextLoads() {
		List<Question> questionAll = questionService.findAll();
		List<Course> courseAll = courseService.findAll();
		System.out.println(questionAll.size());
		System.out.println(courseAll.size());
	}

	/**
	 * courseAndTeacherResultMap
	 * 测试多对一
	 */
	@Test
	void contextLoads2() {
		List<Course> courseList = courseService.findAll();
		courseList.forEach(b->{
			System.out.println(b.toString());
		});

	}
}
