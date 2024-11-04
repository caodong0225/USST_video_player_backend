package top.caodong0225.videoplayer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.caodong0225.videoplayer.entity.VideoInfo;
import top.caodong0225.videoplayer.mapper.VideoInfoMapper;
import top.caodong0225.videoplayer.service.IVideoInfoService;

import java.util.List;

/**
 * @author jyzxc
 * @since 2024-11-03
 */
@Service
public class VideoInfoServiceImpl extends ServiceImpl<VideoInfoMapper, VideoInfo> implements IVideoInfoService {
    @Override
    public List<VideoInfo> getVideoInfos() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<VideoInfo> getVideoInfosNotVisited(Integer userId) {
        return baseMapper.getVideoInfosNotVisited(userId);
    }


}
