package com.bgamq.atcrowd.controller;

import com.bgamq.atcrowd.api.MySQLRemoteService;
import com.bgamq.atcrowd.constant.CrowdConstant;
import com.bgamq.atcrowd.po.MemberPO;
import com.bgamq.atcrowd.util.ResultEntity;
import com.bgamq.atcrowd.vo.MemberLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    @RequestMapping("auth/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return  "redirect:/";
    }

    @RequestMapping("/auth/member/do/login")
    public String login(@RequestParam("loginacct") String loginacct,
                        @RequestParam("userpswd") String userpswd,
                        ModelMap modelMap,
                        HttpSession session){

        ResultEntity<MemberPO> loginAcctRemote = mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);
        if(ResultEntity.FAILED.equals(loginAcctRemote.getResult())){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE,loginAcctRemote.getMessage());
            return "member-login";
        }

        MemberPO memberPO = loginAcctRemote.getData();

        if(memberPO == null){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE,CrowdConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        String userBaseData = memberPO.getUserpswd();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(userpswd, userBaseData);

        if(!matches){
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE,CrowdConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        MemberLoginVO memberLoginVO = new MemberLoginVO(memberPO.getId(),memberPO.getUsername(),memberPO.getEmail());
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER,memberLoginVO);
//        return "redirect:http://localhost/auth/member/to/center/page";
        return "redirect:http://localhost";
    }
}
