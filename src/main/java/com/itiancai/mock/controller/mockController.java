package com.itiancai.mock.controller;

import com.google.gson.Gson;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    //开通协议
    //开通投资协议http://localhost:8080/api/v2/upayment/bindAgreementReturn?ret_code=0000&user_id=UB201501221442450000000002741552&user_bind_agreement_list=ZTBB0G00,0000
    //开通划款协议http://localhost:8080/api/v2/upayment/bindAgreementReturn?ret_code=0000&user_id=UB201501221442450000000002741552&user_bind_agreement_list=ZHKB0H01,0000
    logger.info(service);
    logger.info(str);
    return str;
  }
}
