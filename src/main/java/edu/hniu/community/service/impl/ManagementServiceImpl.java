package edu.hniu.community.service.impl;

import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author jerry
 */
@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ManagementDao managementDao;

    /**
     * 登录验证
     * 其返回值为Object or null。所有判断它是否为空。
     *
     * @param userInfo
     * @return
     */
    public boolean loginCheck(UserInfo userInfo) {
        RoleInfo roleinfo = managementDao.loginCheck(userInfo);
        boolean falg = false;
        if (roleinfo != null) {
            falg = true;
        }
        return falg;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<UserInfo> getAllUserinfo() {
        return managementDao.getAllUserinfo();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteUser(Integer id) {
        return managementDao.deleteUser(id) > 0;
    }
}
