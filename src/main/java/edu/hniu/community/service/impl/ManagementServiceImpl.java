package edu.hniu.community.service.impl;

import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.UserRoleVo;
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
    @Override
    public boolean loginCheck(UserInfo userInfo) {
        RoleInfo roleinfo = managementDao.loginCheck(userInfo);
        boolean flag = false;
        if (roleinfo != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<UserInfo> getAllUserinfo() {
        return managementDao.getAllUserinfo();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteUser(Integer id) {
        return managementDao.deleteUser(id) > 0;
    }

    @Override
    public boolean resetPassword(UserInfo userInfo) {
        return managementDao.resetPassword(userInfo) > 0;
    }

    /**
     * 查询所有的role
     *
     * @return
     */
    @Override
    public List<RoleInfo> getAddzuId() {
        return managementDao.getAddzuId();
    }


    /**
     * 管理员插入数据并指名权限角色
     *
     * @param userRoleVo
     * @return
     */
    @Override
    public boolean addUserInfo(UserRoleVo userRoleVo) {
        boolean flag = false;
        boolean addUserInfo = managementDao.addUserInfo(userRoleVo)>0;
        boolean addUserInfoByRole = managementDao.addUserInfoByRole(userRoleVo)>0;
        if (addUserInfo && addUserInfoByRole){
            flag=true;
        }
        return flag;
    }

    @Override
    public List<QuestionListVo> getAllQusetion() {
        return managementDao.getAllQusetion();
    }

//    @Override
//    public boolean deleteQuestion(Integer id) {
//        boolean flag=false;
//        managementDao.deleteQuestion(id)
//        return  flag;
//    }
}
