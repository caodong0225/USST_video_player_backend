package top.caodong0225.videoplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jyzxc
 * @since 2024-11-03
 */
@SpringBootApplication
@MapperScan("top.caodong0225.videoplayer.mapper")
public class VideoPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoPlayerApplication.class, args);
    }

}
