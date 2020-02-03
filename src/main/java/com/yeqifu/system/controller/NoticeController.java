package com.yeqifu.system.controller;

import com.yeqifu.system.common.ActiveUser;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.Notice;
import com.yeqifu.system.service.NoticeService;
import com.yeqifu.system.vo.NoticeVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/2/2 20:04
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询所有公告
     * @param noticeVo
     * @return          DataGridView
     */
    @RequestMapping("loadAllNotice")
    public Object loadAllNotice(NoticeVo noticeVo){
        return noticeService.queryAllNotice(noticeVo);
    }

    /**
     * 添加公告
     * @param notice
     * @return          ResultObj
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(Notice notice){
        try {
            Subject subject = SecurityUtils.getSubject();
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            notice.setOpername(activeUser.getUser().getName());
            notice.setCreatetime(new Date());
            noticeService.save(notice);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改公告
     * @param notice
     * @return          ResultObj
     */
    @RequestMapping("updateNotice")
    public ResultObj updateNotice(Notice notice){
        try {
            noticeService.updateById(notice);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除一条公告
     * @param id    公告id
     * @return      ResultObj
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(Integer id){
        try {
            noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     * @param ids   公告id形成的数组
     * @return      ResultObj
     */
    @RequestMapping("batchDeleteNotice")
    public ResultObj batchDeleteNotice(Integer[] ids){
        try {
            if (null!=ids&&ids.length>0){
                List<Integer> idsList = new ArrayList<>();
                for (Integer id : ids) {
                    idsList.add(id);

                }
                noticeService.removeByIds(idsList);
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
