package edu.hniu.community.dao;


import edu.hniu.community.domain.Question;
import edu.hniu.community.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoDao {

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    int loginCheck(UserInfo userInfo);


    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    int register(UserInfo userInfo);

    /**
     * cookie的value保存到数据库中
     *
     * @param token
     * @return
     */
    int updateToken(@Param("token") String token, @Param("email") String email);

    /**
     * 根据cookie的值去查询数据库的token
     *
     * @param token
     * @return
     */
    String getToken(String token);

    /**
     * 根据email去查询到accountName的值
     *
     * @param email
     * @return
     */
    String getAccountName(String email);

    /**
     * 重置密码
     *
     * @param userInfo
     * @return
     */
    int resetPassword(UserInfo userInfo);

    /**
     * 异步查询
     *
     * @param email
     * @return
     */
    int findUserByEmail(String email);

    /**
     * 修改个人信息
     *
     * @param userInfo
     * @return
     */
    int updateMassge(UserInfo userInfo);

    /**
     * 查询UserInfo所有信息
     * @param email
     * @return
     */
    UserInfo getUserConfig(String email);

    /**
     * 根据email查询对应用户的id
     *
     * @param email
     * @return
     */
    long getIdByEmail(String email);


    /**
     * 根据email查询其下的所有question
     * @param email
     * @return
     */
    List<Question> getQuestionByEmail(String email);

}
