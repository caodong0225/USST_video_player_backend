package top.caodong0225.videoplayer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.caodong0225.videoplayer.entity.VideoInfo;

import java.util.List;

/**
 * @author jyzxc
 * @since 2024-11-03
 */
public interface VideoInfoMapper extends BaseMapper<VideoInfo> {
    @Select("SELECT vi.*\n" +
            "FROM video_info vi\n" +
            "         LEFT JOIN user_video uv ON vi.id = uv.video_id AND uv.user_id = #{userId}\n" +
            "WHERE uv.video_id IS NULL;")
    List<VideoInfo> getVideoInfosNotVisited(Integer userId);
}
