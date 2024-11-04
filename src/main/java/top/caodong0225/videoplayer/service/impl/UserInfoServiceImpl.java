package top.caodong0225.videoplayer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.caodong0225.videoplayer.entity.UserInfo;
import top.caodong0225.videoplayer.mapper.UserInfoMapper;
import top.caodong0225.videoplayer.service.IUserInfoService;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Override
    public UserInfo getUserInfoByUuid(String uuid) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uuid", uuid);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public UserInfo insertUserInfo(String uuid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUuid(uuid);
        baseMapper.insert(userInfo);
        return userInfo;
    }
}
