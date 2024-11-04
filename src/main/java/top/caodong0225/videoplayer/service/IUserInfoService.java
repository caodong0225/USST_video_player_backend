package top.caodong0225.videoplayer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.caodong0225.videoplayer.entity.UserInfo;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
public interface IUserInfoService extends IService<UserInfo> {
    UserInfo getUserInfoByUuid(String uuid);

    UserInfo insertUserInfo(String uuid);
}
