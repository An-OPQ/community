package edu.hniu.community.service.impl;

import edu.hniu.community.dao.UserInfoDao;
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
     *登录验证
     * @param userInfo
     * @return
     */
    public boolean loginCheck(UserInfo userInfo) {
        return userInfoDao.loginCheck(userInfo)>0;
    }

    /**
     * 注册
     * @param userInfo
     * @return
     */
    public boolean register(UserInfo userInfo) {
        return userInfoDao.register(userInfo)>0;
    }

    /**
     * 重置密码
     * @param userInfo
     * @return
     */
    public boolean resetPassword(UserInfo userInfo) {
        return userInfoDao.resetPassword(userInfo)>0;
    }

    /**
     * 异步查询
     * @param email
     * @return
     */
    public boolean findUserByEmail(String email) {
        return userInfoDao.findUserByEmail(email)>0;
    }

    /**
     *
     * @param userInfo
     * @return
     */
    public boolean updateMassge(UserInfo userInfo) {
        return userInfoDao.updateMassge(userInfo)>0;
    }


    /**
     *查询所有的UserInfo
     * @return
     */
    public UserInfo getUserConfig(String email) {
        return userInfoDao.getUserConfig(email);
    }
}
