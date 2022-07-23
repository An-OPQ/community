package org.springblade.easypoi.annotation.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.easypoi.annotation.entity.Question;
import org.springblade.easypoi.annotation.mapper.QuestionMapper;
import org.springblade.easypoi.annotation.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 */
@Service
@DS("community")
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {


	/**
	 * 查询所有type==1 的文章信息
	 * @return
	 */
	@Override
	public List<Question> findAll() {
		LambdaQueryWrapper<Question> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.ge(Question::getTypeid, "1");
		return baseMapper.selectList(queryWrapper);
	}
}
