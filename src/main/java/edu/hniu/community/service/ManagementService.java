package edu.hniu.community.service;

import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.QuestionTypeVo;
import edu.hniu.community.vo.userAndRoleListVo;

import java.util.List;

/**
 * @author jerry
 */
public interface ManagementService {

    /**
     * 管理员登录检测
     *
     * @param userInfo
     * @return
     */
    boolean loginCheck(UserInfo userInfo);

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
    boolean deleteUser(Integer id);

    /**
     * 管理员权限重置密码
     *
     * @param userInfo
     * @return
     */
    boolean resetPassword(UserInfo userInfo);

    /**
     * 查询所有的role
     * @return
     */
    List<RoleInfo> getAddzuId();

    /**
     * 管理员插入数据并指名权限角色
     * @param userInfo
     * @return
     */
    boolean addUserInfo(UserInfo userInfo);

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
    boolean deleteQuestion(Integer id);


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
    boolean deleteTagById(int id);

    /**
     * 添加模块名
     * @param questionTypeVo
     * @return
     */
    boolean addTag(QuestionTypeVo questionTypeVo);
}
