package org.springblade.easypoi.annotation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.easypoi.annotation.entity.TeacherEntity;
import org.springframework.stereotype.Repository;

/**
 * @author jerry
 */
@Repository
public interface TeacherMapper extends BaseMapper<TeacherEntity> {

	/**
	 * 根据ID去查询Teacher信息
	 * @param id id
	 * @return TeacherEntity
	 */
	TeacherEntity findById(String id);
}
