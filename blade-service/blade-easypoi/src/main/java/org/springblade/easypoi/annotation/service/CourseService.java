package org.springblade.easypoi.annotation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.easypoi.annotation.entity.CourseEntity;

import java.util.List;

/**
 * @author jerry
 */
public interface CourseService extends IService<CourseEntity> {

	/**
	 * 查询所有的Course
	 * @return
	 */
	List<CourseEntity> findAll();
}
