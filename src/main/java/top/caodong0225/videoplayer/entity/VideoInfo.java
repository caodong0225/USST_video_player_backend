package top.caodong0225.videoplayer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@Data
public class VideoInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 视频的名称
     */
    private String videoName;

    /**
     * 视频类型
     */
    private String videoType;

    /**
     * 视频的时长
     */
    private Integer videoTime;
}
