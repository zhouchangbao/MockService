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
        function creatAgreement() {
            var UMPAccount = $('#UMPAccount').val();
            var agreementType=$('#agreementType').val();
            var httpAddr=$('#httpAddr').val();
            window.location.href =
                    httpAddr+"/api/v2/upayment/bindAgreementReturn?ret_code=0000&user_id="
                    + UMPAccount + "&user_bind_agreement_list="+agreementType;
        }
    </script>
</head>
<body>
<table align="center">
    <tr align="center">
        <td align="center">开通UMP协议</td>
    </tr>
    <tr align="center">
        <td align="left">服务地址:<input type="text" id="httpAddr" value="http://localhost:8080"/></td>
    </tr>
    <tr align="center">
        <td align="left">协议类型:
            <select id="agreementType">
                <option value="ZTBB0G00,0000">投资</option>
                <option value="ZTBB0G01,0000">还款</option>
            </select>
        </td>
    </tr>
    <tr align="center">
        <td align="left">UMP账号:<input type="text" id="UMPAccount"/></td>
    </tr>
    <tr align="center">
        <td align="center"><input type="button" onclick="creatAgreement()" value="提交"/></td>
    </tr>
</table>
</body>
</html>
