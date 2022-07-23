package org.springblade.easypoi.annotation.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.easypoi.annotation.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

	/**
	 * CourseEntity 查询全部
	 * @return
	 */
	List<Course> findAll();
}
