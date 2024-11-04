package top.caodong0225.videoplayer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.caodong0225.videoplayer.entity.VideoInfo;

import java.util.List;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
public interface IVideoInfoService extends IService<VideoInfo> {
    List<VideoInfo> getVideoInfos();
    List<VideoInfo> getVideoInfosNotVisited(String uuid);

}
