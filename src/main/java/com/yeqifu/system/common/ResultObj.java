package com.yeqifu.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 落亦-
 * @Date: 2020/1/30 19:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

    private Integer code=200;
    private String msg="";
    private String token="";


    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
