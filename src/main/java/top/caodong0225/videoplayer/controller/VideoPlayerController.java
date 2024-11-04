package top.caodong0225.videoplayer.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.caodong0225.videoplayer.entity.UserInfo;
import top.caodong0225.videoplayer.entity.VideoInfo;
import top.caodong0225.videoplayer.service.IVideoInfoService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static top.caodong0225.videoplayer.util.JwtUtil.SECRET_KEY;

/**
 * @author jyzxc
 * @since 2024-11-03
 */
@Controller
public class VideoPlayerController {
    // 读取配置中的视频文件路径
    @Value("${video.path}")
    private String videoFilePath;

    private final IVideoInfoService videoInfoService;

    @Autowired
    public VideoPlayerController(IVideoInfoService videoInfoService) {
        this.videoInfoService = videoInfoService;
    }

    @GetMapping("/video")
    public ResponseEntity<UrlResource> getVideo(@RequestParam("filename") String filename) throws IOException {
        Path videoPath = Paths.get(videoFilePath, filename);
        UrlResource videoResource = new UrlResource(videoPath.toUri());

        if (!videoResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(videoResource);
    }

    @GetMapping("/play")
    public ResponseEntity<UrlResource> getRandomVideo(HttpServletRequest request) throws IOException {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return ResponseEntity.badRequest().build();
        }
        UserInfo userInfo = parseToken(token);
        List<VideoInfo> videoInfos = videoInfoService.getVideoInfosNotVisited(userInfo.getUuid());
        if (videoInfos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        Path videoPath = Paths.get(videoFilePath, "loading.mp4");
        UrlResource videoResource = new UrlResource(videoPath.toUri());

        if (!videoResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(videoResource);
    }

    public UserInfo parseToken(String token) {
        Map<String, Object> temp =  JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token).getClaim("user").asMap();
        UserInfo userInfo = new UserInfo();
        userInfo.setId((Integer) temp.get("id"));
        userInfo.setUuid((String) temp.get("uuid"));
        return userInfo;
    }
}
