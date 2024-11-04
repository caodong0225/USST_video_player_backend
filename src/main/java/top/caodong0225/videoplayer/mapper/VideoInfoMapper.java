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
    @Select("SELECT v.*\n" +
            "FROM video_info v\n" +
            "         LEFT JOIN user_video uv ON v.id = uv.video_id\n" +
            "         LEFT JOIN user_info u ON uv.user_id = u.id AND u.uuid = #{uuid}\n" +
            "WHERE u.id IS NULL;")
    List<VideoInfo> getVideoInfosNotVisited(String uuid);
}
