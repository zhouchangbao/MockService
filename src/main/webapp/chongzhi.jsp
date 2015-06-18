<%--
  Created by IntelliJ IDEA.
  User: pansen
  Date: 15/6/12
  Time: 下午3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script>
        $(function () {
            $("#yuchongzhi").submit(function(data){
                alert(data);
            });
        });
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
        function yuchongzhi() {
            var httpAddr = $('#httpAddr').val();
            var userID = $('#userID').val();
            $("#yuchongzhi").attr("action", httpAddr + "/api/v2/upayment/netSave/" + userID);
            $("#yuchongzhi").submit();
        }
        //调用充值程序
        function chongzhi() {
            var order_id = $('#order_id').val();
            var httpAddr = $('#httpAddr').val();
            window.location.href =
                    httpAddr
                    + "/upayment/netSaveReturn?service=recharge_notify&ret_code=0000&mer_check_date=20150618&com_amt=0&trade_no="
                    + generateMixed(16) + "&mer_id=7099079&sign_type=RSA&ret_msg=充值成功&order_id="
                    + order_id + "&mer_date=20150618&version=4.0";
        }
    </script>
</head>
<body>
<form id="yuchongzhi" enctype="application/x-www-form-urlencoded" method="post">
    <input type="text" name="retUrl" value="test" style="display:none"/>
    <input type="text" name="bank" value="ICBC" style="display:none"/>
    <table align="center">
        <tr align="center">
            <td align="center">充值</td>
        </tr>
        <tr align="center">
            <td align="left">充值金额：<input type="text" id="rechargeValue" name="rechargeValue"
                                         value="100000"/></td>
        </tr>
        <tr align="center">
            <td align="left">userID：<input type="text" id="userID"
                                           value="C3735668-8FCB-4171-8ADB-A9248AAB8695"/></td>
        </tr>
        <tr align="center">
            <td align="left">服务地址:<input type="text" id="httpAddr" value="http://localhost:4000"/>
            </td>
        </tr>
        <tr align="center">
            <td align="left">订单号:<input type="text" id="order_id"/></td>
        </tr>
        <tr align="center">
            <td align="center"><input type="button" onclick="yuchongzhi()" value="预充值"/></td>
            <td align="center"><input type="button" onclick="chongzhi()" value="充值"/></td>
        </tr>
    </table>
</form>
</body>
</html>
