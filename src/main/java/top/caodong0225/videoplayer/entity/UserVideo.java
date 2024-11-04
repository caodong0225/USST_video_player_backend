package top.caodong0225.videoplayer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@Data
public class UserVideo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户的ID
     */
    private Integer userId;

    /**
     * 视频的ID
     */
    private Integer videoId;

    /**
     * 最后看视频的时间
     */
    private LocalDateTime lastVisitedTime;

    /**
     * 观看视角
     */
    private Integer duration;
}
