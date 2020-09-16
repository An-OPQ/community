package edu.hniu.community.dao;

import edu.hniu.community.domain.Notice;
import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.vo.NoticeVo;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.QuestionTypeVo;
import edu.hniu.community.vo.userAndRoleListVo;

import java.util.List;

/**
 * @author jerry
 */
public interface ManagementDao {

    /**
     * 管理员登录检测
     * @param userInfo
     * @return
     */
    RoleInfo loginCheck(UserInfo userInfo);

    /**
     * 查询所有的用户
     * @return
     */
    List<userAndRoleListVo> getAllUserinfo();

    /**
     * 删除用户
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
     * @return
     */
    List<RoleInfo> getAddzuId();

    /**
     * 管理员插入数据并指名权限角色(插入！role信息)
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);


    /**
     * 管理员查询所有的question列表
     * @return
     */
    List<QuestionListVo> getAllQusetion();

    /**
     * 删除帖子以及帖子的回复
     * @param id
     * @return
     */
    int deleteQuestion(Integer id);

    /**
     *
     * @return
     */
    List<QuestionType> getAllTagName();

    /**
     * 删除模块名
     * @param id
     * @return
     */
    int deleteTagById(int id);

    /**
     * 添加模块名
     * @param questionTypeVo
     * @return
     */
    int addTag(QuestionTypeVo questionTypeVo);

    /**
     * 发布广告
     * @param noticeVo
     * @return
     */
    int publishAdvert(NoticeVo noticeVo);
}
