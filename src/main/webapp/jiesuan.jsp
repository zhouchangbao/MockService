<%--
  Created by IntelliJ IDEA.
  User: pansen
  Date: 15/8/13
  Time: 上午3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/spay/pay/tenderBalanceQuery.do" method="post">

    标的账户：<input type="text" name="id"/>

    标的账户余额(分)：<input type="text" name="value"/>
             <input type="submit" value="提交"/>
    <br/>

</form>
</body>
</html>
