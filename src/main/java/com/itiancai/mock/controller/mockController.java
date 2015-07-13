package com.itiancai.mock.controller;

import com.google.gson.Gson;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pansen on 15/6/5.
 */
@Controller
@RequestMapping("/spay/pay")
public class mockController {

  Logger logger=Logger.getLogger(this.getClass().getName());
//  @ResponseBody
  @RequestMapping(value = "payservice",produces = "text/html")
  public ModelAndView mockService(@RequestParam("service") String service, HttpServletRequest request) {
    ModelAndView view = new ModelAndView("/spay/pay/register.do?");
    return view;

  }
  //实名认证以及投资
  @ResponseBody
  @RequestMapping(value = "register",produces = "text/html")
  public String test(HttpServletRequest request){
    String service=request.getParameter("service");
    String order_id = request.getParameter("order_id");
    String str = "";
    //实名认证mock
    if ("mer_register_person".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "<META NAME=\"MobilePayPlatform\" CONTENT=\"account_id="+RandomStringUtils.randomNumeric(14)+"&mer_id=7099079&reg_date=20150602&ret_code=0000&ret_msg=交易成功。&sign_type=RSA&user_id=UB"+RandomStringUtils.randomNumeric(30)+"&version=1.0&sign=BF7kfv3+d1l0wh3/hhJpS16pDgEhVLUzYxkzkmu25T92mbiM0yEyFWJWHV+YmodcNsiYKGPDC19HVBENf2rxdyReUPOrecKkAM+f9lh24mv7HapMhJl/48XvDoTR9dy/JMAOsvaZ+lAsX7GF4is7q9WWAffSh1FkXjSwyRbnbT8=\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }
    //投标mock
    if ("project_transfer_nopwd".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "<META NAME=\"MobilePayPlatform\" CONTENT=\"mer_check_date=20150604&mer_date=20150604&mer_id=7099079&order_id=16103813557010951515&ret_code=0000&ret_msg=交易成功。&sign_type=RSA&trade_no=1506045029435135&version=1.0&sign=gabAVsQKP0osJDl4tm0EBhMkVTANwu6ELn4o96E5fmXd8LPm3EaIUpGTc6Xss8UmVzpzs7e59S2EhMDx1ucAVnH+2L8Pz8KdPynIgY173g4VsplhtAQzXxCrHlFk6a6K+LXqWr1wshUzoSzQ1kUhWXifHmDyHpB1YflLuPBLTh0=\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }
    //创建标的账户
    if ("mer_bind_project".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"mer_check_date=20150619&mer_id=7099079&project_account_id="+RandomStringUtils.randomNumeric(15)+"&project_state=92&ret_code=0000&ret_msg=操作成功&sign_type=RSA&version=1.0&sign=wwyaS1i29jWdSUaXNxxgKNGpM813E7ijdzaC/oNngcDwE8mWLvmCGzCy83YGTnFOJGMAa+/DoefpnUbGgjfnqEhWfmzaBrMfrTIj2AVW8a5m2BSaC93UDZx+7uvoSvydqqQL2jRgVRd+BRfcEZXJkWabfnk+EixIcvC5zU7R5Gw=\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }
    //结算：转手续费，以及转账给借款人
    if ("project_transfer".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"mer_check_date=20150619&mer_id=7099079&ret_code=0000&ret_msg=操作成功&sign_type=RSA&version=1.0&sign=wwyaS1i29jWdSUaXNxxgKNGpM813E7ijdzaC/oNngcDwE8mWLvmCGzCy83YGTnFOJGMAa+/DoefpnUbGgjfnqEhWfmzaBrMfrTIj2AVW8a5m2BSaC93UDZx+7uvoSvydqqQL2jRgVRd+BRfcEZXJkWabfnk+EixIcvC5zU7R5Gw=\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }

    //商户账户查询
    if ("ptp_mer_query".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"account_state=1&account_type=01&balance=10000000&mer_id=7099079&query_mer_id=7099079&ret_code=0000&ret_msg=查询成功&sign_type=RSA&version=1.0&sign=CmzTL3muTQe3zqWwXxKjuiPSh8ceppjDaQeFo1Fyux2hwygIHlthWqP8rVwm/GWqpyYqa0tFIoMMeoUZzDQh18XrIgZU0UYFGy5MSY9uWBTaKTmAcKaJK86MZpIfQdLJO7HTVx376wl6W9/QegwY2YnZ+tiB9aijfL7dRrIhmJI=\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }

    //商户快速取现
    if ("mer_withdrawals".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"ret_code=0000&ret_msg=交易成功&order_id=" + order_id + "&trade_no="+ buildTradeNo(16) +"\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }
    //商户向用户转账
    if ("transfer".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"ret_code=0000&ret_msg=交易成功&order_id=" + order_id + "&trade_no="+ buildTradeNo(16) +"\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }

    if("user_search".equals(service)) {
      str = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
            + "<html>\n"
            + "  <head>\n"
            + "\t<META NAME=\"MobilePayPlatform\" CONTENT=\"ret_code=0000&ret_msg=交易成功&gate_id=CMB" + "\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "  </body>\n"
            + "</html>";
    }
    //开通协议
    //开通投资协议http://localhost:8080/api/v2/upayment/bindAgreementReturn?ret_code=0000&user_id=UB201501221442450000000002741552&user_bind_agreement_list=ZTBB0G00,0000
    //开通划款协议http://localhost:8080/api/v2/upayment/bindAgreementReturn?ret_code=0000&user_id=UB201501221442450000000002741552&user_bind_agreement_list=ZHKB0H01,0000
    logger.info(service);
    logger.info(str);
    return str;
  }

  static String[] strs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
      "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
      "W", "X", "Y", "Z"};

  private static String buildTradeNo(int x) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<x; i++ ) {
      int r = new Random().nextInt(strs.length);
      sb.append(strs[r]);
    }
    return sb.toString();
  }
}
