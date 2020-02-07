package com.yeqifu.system.common;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

/**
 * @Author: 落亦-
 * @Date: 2020/2/6 21:17
 */
public class MD5Utils {

    /**
     * 生成uuid
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 对密码进行加密
     * @param source
     * @param salt
     * @param hashIterations
     * @return
     */
    public static String md5(String source,String salt,Integer hashIterations){
        Md5Hash hash = new Md5Hash(source,salt,hashIterations);
        return hash.toString();
    }

}
