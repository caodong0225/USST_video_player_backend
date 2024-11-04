package top.caodong0225.videoplayer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralDataResponseDTO<T> extends BaseResponseDTO {
    @Schema(description = "响应数据")
    private T data;

    public GeneralDataResponseDTO() {
        super();
    }

    public GeneralDataResponseDTO(T data) {
        super();
        this.data = data;
    }

    public GeneralDataResponseDTO(Integer code, String message) {
        super(code, message);
    }

    public GeneralDataResponseDTO(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }

}