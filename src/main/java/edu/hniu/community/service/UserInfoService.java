package edu.hniu.community.service;

import edu.hniu.community.domain.UserInfo;


public interface UserInfoService {

    /**
     * 登录验证
     * @param userInfo
     * @return
     */
    boolean loginCheck(UserInfo userInfo);

    /**
     * 注册
     * @param userInfo
     * @return
     */
    boolean register(UserInfo userInfo);

    /**
     * 重置密码
     * @param userInfo
     * @return
     */
    boolean resetPassword(UserInfo userInfo);

    /**
     * 异步查询
     * @param email
     * @return
     */
    boolean findUserByEmail(String email);


    /**
     * 修改个人信息
     * @param userInfo
     * @return
     */
    boolean updateMassge(UserInfo userInfo);

    /**
     *查询所有的UserInfo
     * @return
     */
    UserInfo getUserConfig(String email);
}
