package edu.hniu.community.dao;

import edu.hniu.community.domain.*;
import edu.hniu.community.vo.*;

import java.util.List;

/**
 * @author jerry
 */
public interface ManagementDao {

    /**
     * 管理员登录检测
     *
     * @param userInfo
     * @return
     */
    RoleInfo loginCheck(UserInfo userInfo);

    /**
     * 查询所有的用户
     * @param array
     * @return
     */
    List<userAndRoleListVo> getAllUserinfo(int[] array);



    /**
     * 模糊查询用户
     * @param searchUserVo
     * @return
     */
    List<userAndRoleListVo> searchUser(searchUserVo searchUserVo);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 重置密码
     *
     * @param userInfo
     * @return
     */
    int resetPassword(UserInfo userInfo);


    /**
     * 查询所有的role
     *
     * @return
     */
    List<RoleInfo> getAddzuId();

    /**
     * 管理员插入数据并指名权限角色(插入！role信息)
     *
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);


    /**
     * 管理员查询所有的question列表
     *
     * @return
     */
    List<QuestionListVo> getAllQusetion();

    /**
     * 管理员查询所有的question列表
     * @return
     */
    List<QuestionListVo> searchQuestion(searchQuestionVo searchQuestionVo);

    /**
     * 删除帖子以及帖子的回复
     *
     * @param id
     * @return
     */
    int deleteQuestion(Integer id);

    /**
     * @return
     */
    List<QuestionType> getAllTagName();

    /**
     * 删除模块名
     *
     * @param id
     * @return
     */
    int deleteTagById(int id);

    /**
     * 添加模块名
     *
     * @param questionTypeVo
     * @return
     */
    int addTag(QuestionTypeVo questionTypeVo);

    /**
     * 发布广告
     *
     * @param noticeVo
     * @return
     */
    int publishNotice(NoticeVo noticeVo);

    /**
     * 查询最近一条通知
     *
     * @return
     */
    Notice getNotice();

    /**
     * 更新公告
     *
     * @param noticeVo
     * @return
     */
    int updateNotice(NoticeVo noticeVo);


    /**
     * 发布广告
     *
     * @param advert
     * @return
     */
    int publishAdvert(Advert advert);

    /**
     * 批量删除
     * @param array
     * @return
     */
    int deleteBatch(int[] array);

    /**
     * 查询所有的评论
     * @return
     */
    List<AllCommentVo> getAllComment();

    /**
     * 删除评论
     * @param allCommentVo
     * @return
     */
    int deleteComment(AllCommentVo allCommentVo);

    /**
     * 置顶功能-查询当前帖子的LikeCount
     * @param id
     * @return
     */
    Question getLikeCountByTopPost(long id);

    /**
     * 置顶功能-查询顶部帖子的LikeCount
     * @return
     */
    Question getTopQuestion();

    /**
     * 置顶功能-交换帖子的LikeCount
     * @param question
     * @return
     */
    int updateQuestionByTopPost(Question question);
}
