package top.caodong0225.videoplayer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
@Getter
@Setter
@Schema(description = "基础响应体")
public class BaseResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "响应状态码")
    private Integer code;
    @Schema(description = "响应消息")
    private String message;

    public BaseResponseDTO() {
        this.code = 200;
        this.message = "ok";
    }

    public BaseResponseDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseResponseDTO makeResponse(int code, String message) {
        return new BaseResponseDTO(code, message);
    }

    public static BaseResponseDTO makeResponse(int status) {
        return new BaseResponseDTO(status, HttpStatus.valueOf(status).getReasonPhrase());
    }
}
