<%--
  Created by IntelliJ IDEA.
  User: bao
  Date: 15/7/10
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script>
        var notify_list = {
            'T0':{valid:false, page: "", back: "",tile:""},
            'T1':{valid:true, page: "bindAgreementReturn", back: "bindAgreementReturn", tile:"协议签订"},
            'T2':{valid:true, page: "unbindAgreementReturn", back: "unbindAgreementReturn", tile:"解绑协议"},
            'T3':{valid:true, page: "netSaveReturn", back: "netSaveReturn", tile:"前台充值(个人|企业)"},
            'T4':{valid:true, page: "withdrawReturn", back: "withdrawBgReturn", tile:"前台提现(个人)"},
            'T5':{valid:true, page: "usrAcctPayReturn", back: "usrAcctPayReturn", tile:"前台转账(个人)"},
            'T6':{valid:true, page: "usrAcctPayReturn", back: "usrAcctPayReturn", tile:"转账"},
            'T7':{valid:true, page: "bindCardReturn", back: "bindCardBgReturn", tile:"绑定银行卡"}
        };
        //随机生成16位字母或数字
        var chars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                     'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                     'W', 'X', 'Y', 'Z'];
        function generateMixed(n) {
            var res = "";
            for (var i = 0; i < n; i++) {
                var id = Math.ceil(Math.random() * 35);
                res += chars[id];
            }
            return res;
        }
        function page_notify() {
            var notify_type = $("#notify_type").val();
            console.log(notify_type);
            var notify = notify_list[notify_type];
            var order_id = $('#order_id').val();
            var httpAddr = $('#httpAddr').val();
            var user_id = $('#user_id').val();
            var agreement_list = $('#agreement_list').val();
            var status = $("input:radio:checked").val();
            var notify_url =
                    httpAddr
                    + "/upayment/" +
                    notify.page +
                    "?ret_msg=交易成功" +
                    "&mer_date=20150617" +
                    "&ret_code=" + status +
                    "&order_id="+ order_id +
                    "&user_id="+ user_id +
                    "&trade_state=4" +
                    "&user_bind_agreement_list="+ agreement_list +
                    "&user_unbind_agreement_list="+ agreement_list +
                    "&trade_no=" + generateMixed(16);
            window.open(notify_url);
        }
        //调用充值程序
        function back_notify() {
            var notify_type = $("#notify_type").val();
            var notify = notify_list[notify_type];
            var order_id = $('#order_id').val();
            var httpAddr = $('#httpAddr').val();
            var user_id = $('#user_id').val();
            var amount = $('#amount').val();
            var agreement_list = $('#agreement_list').val();
            var status = $("input:radio:checked").val();
            var notify_url =
                    httpAddr
                    + "/upayment/" +
                    notify.back +
                    "?ret_msg=交易成功" +
                    "&mer_date=20150617" +
                    "&ret_code=" + status +
                    "&order_id="+ order_id +
                    "&user_id="+ user_id +
                    "&amount="+ amount +
                    "&trade_state=4" +
                    "&user_bind_agreement_list="+ agreement_list +
                    "&user_unbind_agreement_list="+ agreement_list +
                    "&trade_no=" + generateMixed(16);
            window.open(notify_url);
        }
    </script>
</head>
<body>
    <table align="center">
        <tr align="center">
            <td align="center" colspan="2">通知</td>
        </tr>
        <tr align="center">
            <td align="right">服务地址:</td>
            <td>
                <input type="text" id="httpAddr" value="http://192.168.0.247"/>
            </td>
        </tr>
        <tr align="center">
            <td align="right">订单号:</td>
            <td>
                <input type="text" id="order_id"/>
            </td>
        </tr>
        <tr align="center">
            <td align="right">联动账号:</td>
            <td>
                <input type="text" id="user_id"/>
            </td>
        </tr>
        <tr align="center">
            <td align="right">取现金额:</td>
            <td>
                <input type="text" id="amount"/>
            </td>
        </tr>
        <tr align="center">
            <td align="right">协议列表(绑定|解绑):</td>
            <td>
                <input type="text" id="agreement_list"/>
            </td>
        </tr>
        <tr align="center">
            <td align="right">成功|失败:</td>
            <td>
                <input type="radio" value="0000" name="status" checked="true"/>成功
                <input type="radio" value="9999" name="status"/>失败
            </td>
        </tr>
        <tr align="center">
            <td align="right">通知类型:</td>
            <td>
                <select id="notify_type">
                    <option value="T0">请选择类型</option>
                    <option value="T1">开通协议</option>
                    <option value="T2">解绑协议</option>
                    <option value="T3">充值(前台|后台)</option>
                    <option value="T4">提现(前台|后台)</option>
                    <option value="T5">转账(个人)</option>
                    <option value="T6">未知</option>
                    <option value="T7">绑定银行卡</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td align="center" colspan="2">
                <input type="button" onclick="page_notify()" value="页面通知"/>
                <input type="button" onclick="back_notify()" value="后台通知"/>
            </td>
        </tr>
    </table>
    <div>
        <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
        参数解释：<br/>
        订单号---->TB_FUND_RECORD orderNo;【充值、提现、转账】<br/>
        联动账号-->TB_UMP_ACCOUNT accountName; 【协议、绑卡】<br/>
        协议列表-->
        ZCZP0800("无密快捷协议"),
        ZTBB0G00("无密投资协议"),
        ZHKB0H01("无密还款协议"),
        ZKJP0700("借记卡快捷协议");多个以“|”分割，例：ZTBB0G00,0000|ZHKB0H01,0000<br/>
        <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
        取现金额-平台提现通知填写(必须调用后台通知)
        <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
        通知地址：<br/>
        蓝海测试地址：http://192.168.0.247(前台)，http://192.168.0.247:8080(后台)
        <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
    </div>
</body>
</html>
