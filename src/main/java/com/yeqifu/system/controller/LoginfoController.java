package com.yeqifu.system.controller;

import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.service.LoginfoService;
import com.yeqifu.system.vo.LoginfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/2/1 15:48
 */
@RestController
@RequestMapping("loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 查询所有的登陆日志
     * @param loginfoVo
     * @return
     */
    @RequestMapping("loadAllLoginfo")
    public Object loadAllLoginfo(LoginfoVo loginfoVo){
        return loginfoService.queryAllLoginfo(loginfoVo);
    }

    /**
     * 删除一条日志
     * @param id    日志ID
     * @return
     */
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){
        try {
            loginfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志
     * @param ids   日志ID形成的数组
     * @return
     */
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(Integer[] ids){
        try {
            if (null!=ids&&ids.length>0){
                List<Integer> idsList = new ArrayList<>();
                for (Integer id : ids) {
                    idsList.add(id);
                }
                loginfoService.removeByIds(idsList);
                return ResultObj.BATCHDELETE_SUCCESS;
            }else {
                return ResultObj.BATCHDELETE_ERROR_NEWS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.BATCHDELETE_ERROR;
        }
    }


}
