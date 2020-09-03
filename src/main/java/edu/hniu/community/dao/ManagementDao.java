package edu.hniu.community.dao;

import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;

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
    List<UserInfo> getAllUserinfo();

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
}
