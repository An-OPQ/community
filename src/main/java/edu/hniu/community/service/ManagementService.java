package edu.hniu.community.service;

import edu.hniu.community.domain.UserInfo;

/**
 * @author jerry
 */
public interface ManagementService {

    /**
     * 管理员登录检测
     *
     * @param userInfo
     * @return
     */
    boolean loginCheck(UserInfo userInfo);
}
