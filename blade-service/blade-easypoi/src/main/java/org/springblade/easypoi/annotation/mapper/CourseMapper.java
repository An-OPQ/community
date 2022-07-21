package org.springblade.easypoi.annotation.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.easypoi.annotation.entity.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 */
@Repository
public interface CourseMapper extends BaseMapper<CourseEntity> {

	/**
	 * CourseEntity 查询全部
	 * @return
	 */
	List<CourseEntity> findAll();
}
