package com.lxg.acm.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.lxg.acm.entity.Classifier;
import com.lxg.acm.mapper.ClassifierMapper;
import com.lxg.acm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分类管理
 * Created by 刘雪岗 on 2017/2/13.
 */

@Controller
@RequestMapping("/admin")
public class AdminClassifierController {

    @Autowired
    private ClassifierMapper classifierMapper;

    // 分类列表
    @RequestMapping("/classifier.action")
    public void queryClassifier1(@RequestParam(value="page",required=false)Long page, HttpServletResponse response,
                                 @RequestParam(value="rows",required=false)Long pageSize) throws Exception{
        Long offset = (page - 1) * pageSize;
        List<Classifier> classifierlist = classifierMapper.queryForList(null,offset,
                pageSize);
        JSONObject result=new JSONObject();
        result.put("rows", classifierlist);
        result.put("total", classifierMapper.count());
        ResponseUtil.write(response, result);
    }

    // 添加分类
    @RequestMapping("/addclassifier.action")
    public void addClassifier(Classifier classifier,HttpServletResponse response,Integer cid) throws Exception{
        Long r;
        if(cid != null){ // 更新
            r = classifierMapper.update(classifier.getTitle(),classifier.getCid());
        }else {
            r = classifierMapper.save(classifier);
        }
        JSONObject result=new JSONObject();
        if(r!=0)
            result.put("success", true);
        ResponseUtil.write(response, result);
    }

    // 删除分类
    @RequestMapping("/deleteclassifier.action")
    public void deleteClassifier(String ids,HttpServletResponse response) throws Exception{
        String []idstr=ids.split(",");
        for(int i=0;i<idstr.length;i++){
            classifierMapper.delete(Long.parseLong(idstr[i]));
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
    }

}
