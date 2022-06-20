package com.xt.controller;

import com.xt.pojo.Pu;
import com.xt.pojo.Su;
import com.xt.pojo.Wmu;
import com.xt.service.PuService;
import com.xt.service.SuService;
import com.xt.service.WmuService;
import com.xt.util.CreateVerifiCodeImage;
import com.xt.util.JwtHelper;
import com.xt.util.Result;
import com.xt.pojo.LoginFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 11:12
 */
@RestController
@RequestMapping("/sys")
//@CrossOrigin
public class SystemController {

    @Autowired
    private SuService suService;

    @Autowired
    private WmuService wmuService;

    @Autowired
    private PuService puService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginFrom loginFrom,HttpServletRequest request){
        //校验验证码
        HttpSession session = request.getSession();
        String sessionverifycode =(String)session.getAttribute("verifiCode");
        String loginverifiCode = loginFrom.getVerifiCode();

        if("".equals(sessionverifycode)|| null == sessionverifycode){
            return Result.fail().message("验证码失效，请刷新后重试");
        }
        if(!sessionverifycode.equalsIgnoreCase(loginverifiCode)){
            return Result.fail().message("验证码有误，请重新输入");
        }
        //清除session
        session.removeAttribute("verifiCode");

        //校验用户
        Map<String,Object> map = new LinkedHashMap<>();
        switch (loginFrom.getUserProp()){
            case "3":
                try {
                    Su su = suService.login(loginFrom);
                    if(null != su){
                        String token = JwtHelper.createToken(su.getId().longValue(), 3);
                        map.put("token",token);
//              String token = JSON.toJSONString(user);
                        map.put("username", su.getName());
                        map.put("prop", "3");

                    }else{
                        throw new RuntimeException("用户名或密码错误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case "6":
                try {
                    Wmu wmu = wmuService.login(loginFrom);
                    if(null != wmu){
                        String token = JwtHelper.createToken(wmu.getId().longValue(), 6);
                        map.put("token",token);
                        map.put("username", wmu.getName());
                        map.put("prop", "6");

                    }else{
                        throw new RuntimeException("用户名或密码错误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case "9":
                try {
                    Pu pu = puService.login(loginFrom);
                    if(null != pu){
                        String token = JwtHelper.createToken(pu.getId().longValue(), 9);
                        map.put("token",token);
                        map.put("username", pu.getName());
                        map.put("prop", "9");

                    }else{
                        throw new RuntimeException("用户名或密码错误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
        }
        return Result.fail().message("用户不存在");
    }




    @GetMapping("/getcode")
    public void getVerifiCodeImage(HttpServletRequest request,HttpServletResponse response){
        //获取图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        //获取图片上的验证码
        String verifiCode = new String(CreateVerifiCodeImage.getVerifiCode());
        //将验证码放入session中，为下一次验证做准备
        HttpSession session = request.getSession();
        session.setAttribute("verifiCode",verifiCode);

        //将验证码响应给浏览器
        try {
            ImageIO.write(verifiCodeImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//        public void getVerifiCodeImage(HttpServletRequest request,HttpServletResponse response){
//        //获取图片
//        //获取图片上的验证码
//        //将验证码文本放入session域，为下一次验证做准备
//        //将验证码图片响应给浏览器
//        try {
//            ServletOutputStream os = response.getOutputStream();
//            String vc = VerifyCodeUtil.outputVerifyImage(100, 50, os, 4);
//            HttpSession session = request.getSession();
//            session.setAttribute("verify_code",vc);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


}
