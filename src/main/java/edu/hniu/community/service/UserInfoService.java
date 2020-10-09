package edu.hniu.community.service;

import edu.hniu.community.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoService {

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    boolean loginCheck(UserInfo userInfo);

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    boolean register(UserInfo userInfo);

    /**
     * cookie的value保存到数据库中
     *
     * @param token
     * @return
     */
    boolean updateToken(@Param("token") String token, @Param("email") String email);

    /**
     * 根据cookie的值去查询数据库的token
     *
     * @param token
     * @return
     */
    String getToken(String token);

    /**
     * 根据email去查询到accountName的值
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
    boolean resetPassword(UserInfo userInfo);

    /**
     * 异步查询-查询邮箱
     *
     * @param email
     * @return
     */
    boolean findUserByEmail(String email);

    /**
     * 异步查询-查询用户名
     *
     * @param addName
     * @return
     */
    boolean findUserByName(String addName);


    /**
     * 修改个人信息
     *
     * @param userInfo
     * @return
     */
    boolean updateMassge(UserInfo userInfo);

    /**
     * 查询所有的UserInfo
     *
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

    /**
     * 根据email查询起
     * @param email
     * @return
     */
    List<UserInfo> getAllCommentByEmail(String email);

    /**
     * 查询所有的板块
     * @return
     */
    List<QuestionType> initModel();

    /**
     * 查询通知
     * @return
     */
    Notice getNotice();

    /**
     * 查询最近的一条广告
     * @return
     */
    Advert getAdvert();
}
