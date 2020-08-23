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

    /**
     * 修改个人信息
     * @param userInfo
     * @return
     */
    int updateMassge(UserInfo userInfo);

    /**
     *查询UserInfo所有信息
     * @return
     */
    UserInfo getUserConfig(String email);

    /**
     * 根据email查询对应用户的id
     * @param email
     * @return
     */
    long getIdByEmail(String email);
}