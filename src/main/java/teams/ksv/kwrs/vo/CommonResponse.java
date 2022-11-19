package teams.ksv.kwrs.vo;

import lombok.Getter;
import lombok.Setter;

import static teams.ksv.kwrs.constant.CommonResponseConts.*;

@Getter
@Setter
public class CommonResponse<T> {

    private int status;

    private String msg;

    private T data;

    public CommonResponse(int status) {
        this.status = status;
    }

    public CommonResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public CommonResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResponse<T> createSuccessResult() {
        return new CommonResponse<T>(SUCCESS);
    }

    public static <T> CommonResponse<T> createSuccessResult(T data) {
        return new CommonResponse<T>(SUCCESS, "ok", data);
    }

    public static <T> CommonResponse<T> createFailResult() {
        return new CommonResponse<T>(COMMON_ERROR);
    }

}
