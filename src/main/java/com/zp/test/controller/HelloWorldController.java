package com.zp.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.test.service.HelloWorldService;

@Controller
@RequestMapping("/test")
public class HelloWorldController {

  @Autowired
  private HelloWorldService helloWorldService;


  @RequestMapping("helloworld")
  public String getNewName(@RequestParam("userName") String userName, HttpServletRequest request) {

    String newUserName = helloWorldService.getNewName(userName);

    request.setAttribute("newUserName", newUserName);

    return "helloworld";

  }

  @ResponseBody
  @RequestMapping("helloname")
  public String getName(@RequestParam("userName") String userName, HttpServletRequest request) {

    return userName;

  }

}