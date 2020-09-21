package edu.hniu.community.service.impl;

import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.Notice;
import edu.hniu.community.domain.QuestionType;
import edu.hniu.community.domain.RoleInfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import edu.hniu.community.vo.NoticeVo;
import edu.hniu.community.vo.QuestionListVo;
import edu.hniu.community.vo.QuestionTypeVo;
import edu.hniu.community.vo.userAndRoleListVo;
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
    public List<userAndRoleListVo> getAllUserinfo() {
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
     * @param userInfo
     * @return
     */
    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        return managementDao.addUserInfo(userInfo) > 0;
    }

    @Override
    public List<QuestionListVo> getAllQusetion() {
        return managementDao.getAllQusetion();
    }

    @Override
    public boolean deleteQuestion(Integer id) {
        return managementDao.deleteQuestion(id) > 0;
    }

    @Override
    public List<QuestionType> getAllTagName() {
        return managementDao.getAllTagName();
    }

    @Override
    public boolean deleteTagById(int id) {
        return managementDao.deleteTagById(id)>0;
    }

    @Override
    public boolean addTag(QuestionTypeVo questionTypeVo) {
        return managementDao.addTag(questionTypeVo)>0;
    }

    @Override
    public boolean publishAdvert(NoticeVo noticeVo) {
        return managementDao.publishAdvert(noticeVo)>0;
    }

    @Override
    public Notice getAdvert() {
        return managementDao.getAdvert();
    }

    @Override
    public boolean updateAdvert(NoticeVo noticeVo) {
        return managementDao.updateAdvert(noticeVo)>0;
    }
}
