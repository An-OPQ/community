package edu.hniu.community.service.impl;

import edu.hniu.community.dao.ManagementDao;
import edu.hniu.community.domain.Roleinfo;
import edu.hniu.community.domain.UserInfo;
import edu.hniu.community.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jerry
 */
@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ManagementDao managementDao;

    /**
     * 登录验证
     *
     * @param userInfo
     * @return
     */
    public boolean loginCheck(UserInfo userInfo) {
        Roleinfo roleinfo=managementDao.loginCheck(userInfo);
        boolean falg=false;
        if (roleinfo !=null){
            falg=true;
        }
        return falg;
    }
}
