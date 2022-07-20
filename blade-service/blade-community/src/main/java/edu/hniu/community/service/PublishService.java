package edu.hniu.community.service;

import edu.hniu.community.domain.CommentMulti;
import edu.hniu.community.domain.Question;
import edu.hniu.community.vo.searchQuestionVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author jerry
 */
public interface PublishService {
    /**
     * 帖子发布
     * @param question
     * @return
     */
    boolean publishMessage(Question question);

    /**
     * 查询所有帖子
     * @return
     */
    List<Question> getPublishMessage();

    /**
     * 搜索帖子
     * @param searchQuestionVo
     * @return
     */
    List<Question> searchQuestion(searchQuestionVo searchQuestionVo);

    /**
     * 更新阅读数
     * @param id
     * @return
     */
    boolean updateViewCount(Integer id);

    /**
     * 更新回复数
     *
     * @param id
     * @return
     */
    boolean updateCommentCount(Integer id);

    /**
     * 更新点赞数
     *
     * @param id
     * @return
     */
    boolean addLikeCount(Integer id);

    /**
     * less点赞数
     * @param id
     * @return
     */
    boolean lessLikeCount(Integer id);

    /**
     * 更新question
     * @param question
     * @return
     */
    boolean updateQuestion(Question question);


    /**
     * question点赞数
     * @param id
     * @return
     */
    boolean addQuestionLikeCount(Integer id);

    /**
     * question点赞数
     * @param id
     * @return
     */
    boolean lessQuestionLikeCount(Integer id);

    /**
     * 发布二级评论
     * @param commentMulti
     * @return
     */
    boolean secondarySubmit(CommentMulti commentMulti);

    /**
     * 查询所有的二级评论
     * @param id
     * @return
     */
    List<CommentMulti> secondaryComment(Integer id);
}
