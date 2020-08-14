package edu.hniu.community.dao;

import edu.hniu.community.domain.UserInfo;




public interface UserInfoDao {

    /**
     * 登录验证
     * @param userInfo
     * @return
     */
    int loginCheck(UserInfo userInfo);


    /**
     * 注册
     * @param userInfo
     * @return
     */
    int register(UserInfo userInfo);

    /**
     * 重置密码
     * @param userInfo
     * @return
     */
    int resetPassword(UserInfo userInfo);

    /**
     * 异步查询
     * @param email
     * @return
     */
    int findUserByEmail(String email);
}
