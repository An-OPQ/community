package edu.hniu.community.service.impl;

import edu.hniu.community.dao.UserInfoDao;
import edu.hniu.community.domain.Question;
import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    @Override
    public boolean loginCheck(UserInfo userInfo) {
        return userInfoDao.loginCheck(userInfo)>0;
    }

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    @Override
    public boolean register(UserInfo userInfo) {
        return userInfoDao.register(userInfo) > 0;
    }


    /**
     * cookie的value保存到数据库中
     *
     * @param token
     * @return
     */
    @Override
    public boolean updateToken(String token, String email) {
        return userInfoDao.updateToken(token, email) > 0;
    }


    /**
     * 根据email去查询到accountName的值
     * @param email
     * @return
     */
    @Override
    public String getAccountName(String email) {
        return userInfoDao.getAccountName(email);
    }

    /**
     * 根据cookie的值去查询数据库的token
     *
     * @param token
     * @return
     */
    @Override
    public String getToken(String token) {
        return userInfoDao.getToken(token);
    }

    /**
     * 重置密码
     *
     * @param userInfo
     * @return
     */
    @Override
    public boolean resetPassword(UserInfo userInfo) {
        return userInfoDao.resetPassword(userInfo) > 0;
    }

    /**
     * 异步查询
     *
     * @param email
     * @return
     */
    @Override
    public boolean findUserByEmail(String email) {
        return userInfoDao.findUserByEmail(email) > 0;
    }

    /**
     * @param userInfo
     * @return
     */
    @Override
    public boolean updateMassge(UserInfo userInfo) {
        return userInfoDao.updateMassge(userInfo) > 0;
    }


    /**
     * 查询所有的UserInfo
     *
     * @return
     */
    @Override
    public UserInfo getUserConfig(String email) {
        return userInfoDao.getUserConfig(email);
    }

    /**
     * 根据用户email查询id的值
     *
     * @param email
     * @return
     */
    @Override
    public long getIdByEmail(String email) {
        return userInfoDao.getIdByEmail(email);
    }

    @Override
    public List<Question> getQuestionByEmail(String email) {
        return userInfoDao.getQuestionByEmail(email);
    }

    @Override
    public List<UserInfo> getAllCommentByEmail(String email) {
        return userInfoDao.getAllCommentByEmail(email);
    }

    @Override
    public List<QuestionType> initModel() {
        return userInfoDao.initModel();
    }
}
