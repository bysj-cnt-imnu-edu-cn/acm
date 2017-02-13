package com.lxg.acm.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.lxg.acm.entity.User;
import com.lxg.acm.mapper.UserMapper;
import com.lxg.acm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户管理
 * Created by 刘雪岗 on 2017/2/13.
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    UserMapper userMapper;

    // 用户列表
    @RequestMapping("/userlist.action")
    public void userList1(@RequestParam(value="page",required=false)Long page, HttpServletResponse response,
                          @RequestParam(value="rows",required=false)Long pageSize) throws Exception{
        Long offset = (page - 1) * pageSize;
        List<User> userList = userMapper.queryForList(offset,pageSize);
        JSONObject result=new JSONObject();
        result.put("rows", userList);
        result.put("total", userMapper.count()); // 查询总数
        ResponseUtil.write(response, result);
    }
}
