package edu.hniu.community.service.impl;

import edu.hniu.community.dao.UserInfoDao;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;
    /**
     *登录验证
     * @param userInfo
     * @return
     */
    @Override
    public boolean loginCheck(UserInfo userInfo) {
        return userInfoDao.loginCheck(userInfo)>0;
    }

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @Override
    public boolean register(UserInfo userInfo) {
        return userInfoDao.register(userInfo)>0;
    }

    /**
     * 重置密码
     * @param userInfo
     * @return
     */
    @Override
    public boolean resetPassword(UserInfo userInfo) {
        return userInfoDao.resetPassword(userInfo)>0;
    }

    /**
     * 异步查询
     * @param email
     * @return
     */
    @Override
    public boolean findUserByEmail(String email) {
        return userInfoDao.findUserByEmail(email)>0;
    }
}
