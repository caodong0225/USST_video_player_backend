package top.caodong0225.videoplayer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.caodong0225.videoplayer.entity.UserVideo;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
public interface IUserVideoService extends IService<UserVideo> {
    boolean insertOrUpdateUserVideo(UserVideo userVideo);
}
