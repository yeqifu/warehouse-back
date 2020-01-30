package com.yeqifu.system.common;

import com.yeqifu.system.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/1/30 20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser {
    private User user;
    private List<String> roles;
    private List<String> permission;
}
