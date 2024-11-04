package top.caodong0225.videoplayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.caodong0225.videoplayer.dto.BaseDataResponseDTO;
import top.caodong0225.videoplayer.entity.UserInfo;
import top.caodong0225.videoplayer.service.IUserInfoService;
import top.caodong0225.videoplayer.util.JwtUtil;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@RestController
public class UserController {
    private final IUserInfoService userInfoService;

    @Autowired
    public UserController(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/user")
    public BaseDataResponseDTO getUser(@RequestParam("uuid") String uuid) {
        UserInfo userInfo = userInfoService.getUserInfoByUuid(uuid);
        String token;
        if(userInfo == null) {
            userInfo = userInfoService.insertUserInfo(uuid);
        }
        token = JwtUtil.createToken(userInfo);
        return new BaseDataResponseDTO(token);
    }
}
