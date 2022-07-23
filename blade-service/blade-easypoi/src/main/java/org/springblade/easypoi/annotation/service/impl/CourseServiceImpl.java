package org.springblade.easypoi.annotation.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.easypoi.annotation.entity.Course;
import org.springblade.easypoi.annotation.mapper.CourseMapper;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jerry
 */
@Service
@DS("easypoi")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

	@Resource
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() {
		return courseMapper.findAll();
	}

}
