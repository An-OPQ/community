package org.springblade.easypoi.annotation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.easypoi.annotation.entity.Question;

import java.util.List;

public interface QuestionService extends IService<Question> {

	/**
	 * 查询所有的帖子信息
	 * @return
	 */
	List<Question> findAll();
}
