package com.yeqifu.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: 落亦-
 * @Date: 2020/1/30 20:16
 */
@Data
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    private String hashAlgorithmName="md5";
    private Integer hashIterations=2;
    private String loginUrl;
    private String unauthorizedUrl;
    private String [] anonUrls;
    private String logoutUrl;
    private String [] authcUrls;

}
