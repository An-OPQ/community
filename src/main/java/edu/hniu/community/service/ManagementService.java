package edu.hniu.community.service;

import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.vo.UserRoleVo;

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
    List<UserInfo> getAllUserinfo();

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
     * @param userRoleVo
     * @return
     */
    boolean addUserInfo(UserRoleVo userRoleVo);

}
