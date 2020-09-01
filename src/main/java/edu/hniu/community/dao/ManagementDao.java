package edu.hniu.community.dao;

import edu.hniu.community.domain.Roleinfo;
import edu.hniu.community.domain.UserInfo;

/**
 * @author jerry
 */
public interface ManagementDao {

    /**
     * 管理员登录检测
     * @param userInfo
     * @return
     */
    Roleinfo loginCheck(UserInfo userInfo);
}
