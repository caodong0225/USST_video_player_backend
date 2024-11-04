package top.caodong0225.videoplayer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.caodong0225.videoplayer.entity.UserVideo;
import top.caodong0225.videoplayer.mapper.UserVideoMapper;
import top.caodong0225.videoplayer.service.IUserVideoService;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@Service
public class UserVideoServiceImpl extends ServiceImpl<UserVideoMapper, UserVideo> implements IUserVideoService {
    @Override
    public boolean insertOrUpdateUserVideo(UserVideo userVideo) {
        UserVideo existVideo = this.lambdaQuery().eq(UserVideo::getUserId, userVideo.getUserId())
                .eq(UserVideo::getVideoId, userVideo.getVideoId())
                .one();
        if(existVideo == null) {
            return this.save(userVideo);
        }
        existVideo.setDuration(userVideo.getDuration()+existVideo.getDuration());
        return this.updateById(existVideo);
    }

}
