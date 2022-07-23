package org.springblade.easypoi.annotation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.easypoi.annotation.entity.Course;

import java.util.List;

/**
 * @author jerry
 */
public interface CourseService extends IService<Course> {

	/**
	 * 查询所有的Course
	 * @return
	 */
	List<Course> findAll();
}
