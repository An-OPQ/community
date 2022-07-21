package org.springblade.easypoi.annotation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.easypoi.annotation.entity.Question;
import org.springframework.stereotype.Repository;

/**
 * @author jerry
 */
@Repository
public interface QuestionMapper extends BaseMapper<Question> {
}
