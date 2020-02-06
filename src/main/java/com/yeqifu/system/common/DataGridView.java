package com.yeqifu.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 落亦-
 * @Date: 2020/2/1 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView implements Serializable {

    private Integer code=0;
    private String msg="";
    private Long count=0L;
    private Object data;

    public DataGridView(Object data) {
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}
