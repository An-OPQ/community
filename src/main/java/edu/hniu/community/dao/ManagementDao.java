package edu.hniu.community.dao;

import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.UserRoleVo;
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
     * @param userRoleVo
     * @return
     */
    int addUserInfo(UserRoleVo userRoleVo);

    /**
     * 管理员插入数据并指名权限角色(插入role信息)
     * @param userRoleVo
     * @return
     */
    int addUserInfoByRole(UserRoleVo userRoleVo);

    /**
     * 管理员查询所有的question列表
     * @return
     */
    List<QuestionListVo> getAllQusetion();

//    /**
//     * 删除帖子以及帖子的回复
//     * @param id
//     * @return
//     */
//    int deleteQuestion(Integer id);
//
//    int deleteComment(Integer id);
}
