package com.bgamq.atcrowd.controller;

import com.bgamq.atcrowd.api.MySQLRemoteService;
import com.bgamq.atcrowd.constant.CrowdConstant;
import com.bgamq.atcrowd.util.ResultEntity;
import com.bgamq.atcrowd.vo.PortalTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;


    @RequestMapping("/")
    public String showPortalPage(Model model){

        ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getProjectTypeDataRemote();

        String result = resultEntity.getResult();
        if(ResultEntity.SUCCESS.equals(result)){

            List<PortalTypeVO> data = resultEntity.getData();

            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA,data);

        }


        return "portal";
    }

}
