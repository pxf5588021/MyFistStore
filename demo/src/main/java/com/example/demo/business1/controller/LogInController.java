/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.business1.controller;

import Model.User;
import com.example.demo.business1.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@Api(value = "登录演示 ")
@RestController
public class LogInController {
    @Autowired
    private UserLoginService loginService;

    @ApiOperation(value = "字符串传值")
    @GetMapping("/LogIn1")
    public boolean LogIn1(String name,String pwd)
    {
        return loginService.Login(name,pwd);
    }

    @ApiOperation(value = "HttpServletRequest 获取")
    @GetMapping("/LogIn2")
    public boolean LogIn2(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String  pwd = request.getParameter("pwd");
        return loginService.Login(name,pwd);
    }

    @ApiOperation(value = "对象自动注入")
    @GetMapping(value="/LogIn3")
    public Boolean LogIn3(User user)
    {
        return loginService.Login(user.getName(),user.getPwd());
    }

    @ApiOperation(value = "PathVariable注入来绑定请求路径的参数")
    @GetMapping(value = "/LogIn4/{a}/{bbb}")
    public boolean LogIn4(@PathVariable("a") String a,@PathVariable String bbb)
    {
        return loginService.Login(a,bbb);
    }

    @ApiOperation(value = "RequestParam注入获取")
    @GetMapping(value = "LogIn5")
    public boolean LogIn5(@RequestParam("name") String name,@RequestParam("pwd")String pwd)
    {
        return loginService.Login(name,pwd);
    }

    @ApiOperation(value = "RequestBody post提交  json格式")
    @PostMapping(path = "/LogIn6")
    public boolean LogIn6(@RequestBody User user) { //也可以不用注解
        return loginService.Login(user.getName(),user.getPwd());
    }

   /* @ApiOperation(value = "请求头参数以及Cookie")
    @GetMapping("/LogIn7")
    public String LogIn7(@RequestHeader(name = "myHeader") String myHeader,
                      @CookieValue(name = "myCookie") String myCookie) {
        return myHeader+myCookie;
    }*/
}
