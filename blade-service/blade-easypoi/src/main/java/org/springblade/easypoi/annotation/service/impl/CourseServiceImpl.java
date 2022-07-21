package org.springblade.easypoi.annotation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.easypoi.annotation.entity.CourseEntity;
import org.springblade.easypoi.annotation.mapper.CourseMapper;
import org.springblade.easypoi.annotation.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jerry
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,CourseEntity> implements CourseService {

	@Resource
	private CourseMapper courseMapper;

	@Override
	public List<CourseEntity> findAll() {
		List<CourseEntity> courseEntities = courseMapper.findAll();
		return courseEntities;
	}
}
